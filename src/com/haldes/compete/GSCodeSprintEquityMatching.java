package com.haldes.compete;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * Introduction
 * In the stock trading world, the order book is the place where all active orders (both Buy and Sell) are maintained in certain priority for the purpose of matching buy and sell orders. Orders (both Buy and Sell Sides) can be of different types, for the purposes of this challenge please consider following order types:
 * <p>
 * Market: A Market order is an order to buy or sell a symbol that must be matched at best price on the other side.
 * <p>
 * Market Buy: Amount , where  is current lowest selling price available in the order book.
 * Market Sell: Amount , where  is current highest buying price available in the order book.
 * Limit: A Limit order is an order to buy or sell a symbol that must be matched at a specified price  or better.
 * <p>
 * Limit Buy: Amount , where  is selling price and , eventually.
 * Limit Sell: Amount , where  is buying price and , eventually.
 * IOC: An immediate or cancel order (IOC) is an order to buy or sell a symbol that must be matched at a specified capped price  in the next matching cycle, and any portion of the order that cannot be matched will be automatically canceled.
 * <p>
 * IOC Limit Buy: Amount , where  is selling price and , now.
 * IOC Limit Sell: Amount , where  is buying price and , now.
 * Task
 * In this challenge you should design a matcher engine which performs matching between buy and sell sides of the order book. The matcher receives an input stream consisting of buy and sell orders and after receiving a match command, it should attempt to match any outstanding orders at that point in time. The matcher must ensure that buy order with highest price is matched with sell order with the lowest price. In case of multiple orders have the same price on given side (buy or sell), the matcher should pick order on first come first serve based on timestamp. A buy order for a symbol  at price  can be matched with any sell order on the same symbol  at prices less than or equal to . Thus, a new buy or sell order may be matched with one or more of outstanding sell or buy orders.
 * <p>
 * Commands Description
 * The input command will have the following components, also note that some of the components are optional:
 * <p>
 * Action:  (New),  (Amend),  (Cancel),  (Match) or  (Query).
 * OrderID: An integer value in the range  inclusive.
 * Timestamp: An integer value, typically milliseconds since epoch.
 * Symbol: Varying length string containing only alphabets.
 * OrderType:  (Market),  (Limit) or  (IOC).
 * Side:  (Buy) or  (Sell)
 * Price: A float value,  if OrderType is  (Market). The price is given exactly to two places of decimal.
 * Quantity: An integer value in the range  inclusive.
 * The input command structure depends on the Action component, i.e., there are following five types of input commands:
 * <p>
 * The  (New) command means that a new order is being requested to be entered into the matching book. The matcher should reject the incoming order in case of duplicate order Id or invalid input fields. The command is described as:
 * <p>
 * <p>
 * The matcher should output one of the following:
 * <p>
 * For example, consider the following commands:
 * <p>
 * N,2,0000002,XYZ,L,B,104.53,100
 * N,3,0000002,XYZ,L,B,104.53,100.3
 * The matcher should output the following:
 * <p>
 * 2 - Accept
 * 3 - Reject - 303 - Invalid order details
 * Note that,  is not an integer, so order  is rejected.
 * <p>
 * The  (Amend) command means an existing order is being requested to be updated as per details in this command. A valid amend command should have quantity and/or price amended, any other field update should result into error code.
 * <p>
 * In case of quantity amend down, the amended order should not lose existing priority in the matching book. In all other amend requests, the priority of amended order in matching book may vary according to the latest price and timestamp. Also note that partial amends should be supported. In case of a quantity amend request on a partially executed order, it should be accepted. If the quantity in the amend request is less than or equal to the currently matched quantity, then order should be considered closed. In scenarios where order is fully matched or already cancelled, new amend requests should be rejected. The command is described as:
 * <p>
 * <p>
 * The matcher should output one of the following:
 * <p>
 * For example, consider the following commands:
 * <p>
 * A,2,0000001,XYZ,L,B,103.53,150
 * A,2,0000001,XYZ,L,S,103.53,150
 * The matcher should output the following:
 * <p>
 * 2 - AmendAccept
 * 2 - AmendReject - 101 - Invalid amendment details
 * Note that, we are trying to update the OrderType from buy to sell, so amend order  is rejected.
 * <p>
 * The  (Cancel) command means an existing order is being requested to be canceled. Also note that partial cancels should be supported. In scenarios where order is fully matched or already cancelled, new cancel requests should be rejected. The command is described as:
 * <p>
 * <p>
 * The matcher should output one of the following:
 * <p>
 * For example, consider the following commands:
 * <p>
 * X,1,0000001
 * X,2,0000002
 * X,2,0000002
 * The matcher should output the following:
 * <p>
 * 1 - CancelAccept
 * 2 - CancelAccept
 * 2 – CancelReject - 404 - Order does not exist
 * The  (Match) command means that the existing orders in the matching book should be matched now. The Symbol is an optional parameter if specified would mean matching should be done only for the specified symbol else it should be done for all the symbols in alphabetical order. The command is described by one of the following formats:
 * <p>
 * The matching result has three components which must be separated by a pipe ():
 * <p>
 * Symbol: This represents the matched symbol.
 * MatchedBuy: This represents the information of matched buy. It should have  format.
 * MatchedSell: This represents the information of matched sell. It should have  format.
 * The matcher should output all resulting matches in the following format:
 * <p>
 * <p>
 * In case of no matches, there shouldn't be any output. For example, consider the following commands:
 * <p>
 * N,1,0000001,ALN,L,B,60.90,100
 * N,11,0000002,XYZ,L,B,60.90,200
 * N,110,0000003,XYZ,L,S,60.90,100
 * N,112,0000003,XYZ,L,S,60.90,120
 * N,10,0000006,ALN,L,S,60.90,100
 * M,00010
 * M,00010,ALN
 * The matcher should output the following:
 * <p>
 * ALN|1,L,100,60.90|60.90,100,L,10
 * XYZ|11,L,100,60.90|60.90,100,L,110
 * XYZ|11,L,100,60.90|60.90,100,L,112
 * Note that, there is no output for the match command M,00010,ALN because after the match command M,00010 there are no buy or sell orders to be matched.
 * <p>
 * Also, consider the following commands:
 * <p>
 * N,1,0000001,ALN,L,B,60.90,100
 * N,11,0000002,XYZ,L,B,60.90,200
 * N,110,0000003,XYZ,L,S,60.90,100
 * N,112,0000003,XYZ,L,S,60.90,120
 * N,10,0000006,ALN,L,S,60.90,100
 * M,00010,ALN
 * The matcher should output the following:
 * <p>
 * ALN|1,L,100,60.90|60.90,100,L,10
 * This  (Query) is a request to print the state of matching book. Symbol and Timestamp are optional parameters. If only symbol is specified would mean state of the matching book should be printed for the given symbol. If only timestamp is specified would mean state of the matching book(s) should be printed at the given timestamp for all symbols in alphabetical order. Otherwise, state of the matching book for the given symbol and timestamp should be printed. If no optional parameters are specified, then matcher should print state of the matching book(s) as of now for all symbols in alphabetical order. The command is described by one of the following formats:
 * <p>
 * The state of matching book should be described by the following three components which must be separated by a pipe ():
 * <p>
 * Symbol: This represents the symbol processed for the state of matching book.
 * BuyState: This represent the buy state of the matching book. It should have  format. If there are no corresponding buy orders, this field should be left blank.
 * SellState: This represent the sell state of the matching book. It should have  format. If there are no corresponding sell orders, this field should be left blank.
 * The matcher should output the top five buy and sell entries as the state of the matching book for the given (available) symbols in the following format:
 * <p>
 * <p>
 * In case of Market orders, price should be printed as . For example, consider the following commands:
 * <p>
 * N,1,0000001,ALN,L,B,60.90,100
 * N,13,0000002,ALN,L,B,60.90,100
 * N,10,0000003,ALN,L,S,60.90,100
 * N,12,0000004,ALN,L,S,60.90,100
 * N,11,0000005,ALB,L,S,60.90,100
 * N,14,0000006,ALB,L,S,62.90,101
 * N,16,0000007,ALB,L,S,63.90,102
 * N,18,0000008,ALB,L,S,64.90,103
 * N,20,0000009,ALB,L,S,65.90,104
 * Q,0000003
 * Q,ALB
 * Q,ALN,0000002
 * Q,0000002,ALN
 * Q
 * The matcher should print the following:
 * <p>
 * ALN|1,L,100,60.90|60.90,100,L,10
 * ALN|13,L,100,60.90|
 * ALB||60.90,100,L,11
 * ALB||62.90,101,L,14
 * ALB||63.90,102,L,16
 * ALB||64.90,103,L,18
 * ALB||65.90,104,L,20
 * ALN|1,L,100,60.90|
 * ALN|13,L,100,60.90|
 * ALN|1,L,100,60.90|
 * ALN|13,L,100,60.90|
 * ALB||60.90,100,L,11
 * ALB||62.90,101,L,14
 * ALB||63.90,102,L,16
 * ALB||64.90,103,L,18
 * ALB||65.90,104,L,20
 * ALN|1,L,100,60.90|60.90,100,L,10
 * ALN|13,L,100,60.90|60.90,100,L,12
 * Note that:
 * <p>
 * The query command Q,0000003 should return the first two lines of the output.
 * The query command Q,ALB should return the next five lines of the output.
 * The query command Q,ALN,0000002 should return the next two lines of the output.
 * The query command Q,0000002,ALN should return the next two lines of the output.
 * The query command Q should return the last seven lines of the output.
 * Note that:
 * <p>
 * If the value of OrderType is other than  (Market),  (Limit), or  (IOC), then the matcher should reject the command and output the valid rejection message.
 * If the value of Side is other than  (Buy) or  (Sell), then the matcher should reject the command and output the valid rejection message.
 * For query command, in case of partially executed order only remaining quantity should be printed.
 * We might run additional test cases offline apart from the test cases setup in hackerrank.
 * Test Cases Distribution
 * The first test case,  is sample test case.
 * The second test case,  has  (New) commands only.
 * The third test case,  has  (New),  (Amend), and  (Match) commands only.
 * The fourth test case,  has  (New),  (Match), and  (IOC) OrderType commands only.
 * Rest of the test cases test combination of different commands.
 * Input Format
 * <p>
 * The first line of the input contains an integer  describing the total number of commands. Each of the subsequent line contains a comma-separated string describing the command.
 * <p>
 * The commands are read by the code stub in the editor below and passed to processQueries function as parameter. You should complete the function and return the result of each command as a string array. Note that, any sort of look-ahead is not allowed and any submission utilizing look-ahead will not be considered for evaluation.
 * <p>
 * Constraints
 * <p>
 * Price and quantity can not be negative.
 * Any input command having lower timestamp than the previous command should be rejected, except query command.
 * Orders that are fully matched or canceled do not further participate in matching.
 * Output Format
 * <p>
 * The code stub in the editor below prints the result of each query on a new line.
 * <p>
 * Sample Input 0
 * <p>
 * 12
 * N,1,0000001,AB,L,B,104.53,100
 * N,2,0000002,AB,L,S,105.53,100
 * N,3,0000003,AB,L,B,104.53,90
 * M,0000004
 * N,4,0000005,AB,L,S,104.43,80
 * A,2,0000006,AB,L,S,104.42,100
 * Q
 * M,0000008
 * N,5,0000009,AB,L,S,105.53,120
 * X,3,0000010
 * N,6,0000011,XYZ,L,B,1214.82,2568
 * Q
 * Sample Output 0
 * <p>
 * 1 - Accept
 * 2 - Accept
 * 3 - Accept
 * 4 - Accept
 * 2 - AmendAccept
 * AB|1,L,100,104.53|104.42,100,L,2
 * AB|3,L,90,104.53|104.43,80,L,4
 * AB|1,L,100,104.42|104.42,100,L,2
 * AB|3,L,80,104.43|104.43,80,L,4
 * 5 - Accept
 * 3 - CancelAccept
 * 6 - Accept
 * AB||105.53,120,L,5
 * XYZ|6,L,2568,1214.82|
 */

public class GSCodeSprintEquityMatching {


    /*
     * Complete the function below.
     */
    static String[] processQueries(String[] queries) {
        // Write your code here
        // This  is the ledger
        HashMap<String, Order> book = new HashMap<>();

        String[] str = new String[queries.length];
        System.out.println("queries"+ queries[0]);

        EquityMatching eq = new EquityMatching();
        // TODO validate input
        ArrayList<Order> orderList = new ArrayList<>();
        try {
            orderList = eq.prepInput(queries);
        } catch (Exception e) {
            return error(queries[0]);
        }
        System.out.println("Order List : " + orderList);


        // TODO Implement Insert



        str[0] = "sumit";
        return str;
    }

    private static String[] error(String query) {
        System.out.println("Exception happened !!!");
        String[] err = new String[1];
        err[0] = query.split(",")[1].trim()+" - Reject - 303 - Invalid order details";
        return err;
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int queriesSize = Integer.parseInt(scan.nextLine().trim());
        System.out.println("Scanner "+ queriesSize);
        String[] queries = new String[queriesSize];

        for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
            String queriesItem = scan.nextLine();
            queries[queriesItr] = queriesItem;
        }*/
        String[] queries = new String[1];
        queries[0] = "N,1,0000001,AB,L,B,104.53,100";
        String[] response = processQueries(queries);

        System.out.println("Result : "+response[0]);

        /*for (int responseItr = 0; responseItr < response.length; responseItr++) {
            bw.write(response[responseItr]);
            if (responseItr != response.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();
        bw.close();*/
    }

    /**
     * Action:  (New),  (Amend),  (Cancel),  (Match) or  (Query).
     OrderID: An integer value in the range  inclusive.
     Timestamp: An integer value, typically milliseconds since epoch.
     Symbol: Varying length string containing only alphabets.
     OrderType:  (Market),  (Limit) or  (IOC).
     Side:  (Buy) or  (Sell)
     Price: A float value,  if OrderType is  (Market). The price is given exactly to two places of decimal.
     Quantity: An integer value in the range  inclusive.
     */


}


class EquityMatching {
    public HashMap<String,Order> insert(HashMap<String,Order> book, Order order){


        return new HashMap<String,Order>();
    }

    public ArrayList<Order> prepInput(String[] queries) throws Exception{

        boolean isError = false;
        ArrayList<Order> orderList = new ArrayList<>();
        for( String str : queries){
            String[] arr = str.split(",");
            if(arr.length != 8){
                throw new Exception();
            } else {
                String Action = new String(arr[0]);
                Integer OrderID = new Integer(Integer.parseInt(arr[1]));
                Integer Timestamp = new Integer(Integer.parseInt(arr[2]));
                String Symbol = new String(arr[3]);
                String OrderType = new String(arr[4]);
                String Side = new String(arr[5]);
                float Price = new Float(Float.parseFloat(arr[6]));
                Integer Quantity = new Integer(Integer.parseInt(arr[7]));
                Order o = new Order(Action, OrderID, Timestamp, Symbol, OrderType, Side, Price, Quantity);
                orderList.add(o);
            }
        }
        return orderList;
    }


}

class Order {
    public String Action;
    public Integer OrderID;
    public Integer Timestamp;
    public String Symbol;
    public String OrderType;
    public String Side;
    public float Price;
    public Integer Quantity;

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public Integer getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        Timestamp = timestamp;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }

    public String getSide() {
        return Side;
    }

    public void setSide(String side) {
        Side = side;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Order(String action, Integer orderID, Integer timestamp, String symbol, String orderType, String side, float price, Integer quantity) {
        Action = action;
        OrderID = orderID;
        Timestamp = timestamp;
        Symbol = symbol;
        OrderType = orderType;
        Side = side;
        Price = price;
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Action='" + Action + '\'' +
                ", OrderID=" + OrderID +
                ", Timestamp=" + Timestamp +
                ", Symbol='" + Symbol + '\'' +
                ", OrderType='" + OrderType + '\'' +
                ", Side='" + Side + '\'' +
                ", Price=" + Price +
                ", Quantity=" + Quantity +
                '}';
    }
}