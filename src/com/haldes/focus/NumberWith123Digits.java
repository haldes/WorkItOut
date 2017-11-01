package com.haldes.focus;

/**
 1. Given an array of numbers, print only those numbers which have 1, 2 and 3 as digits.
 the numbers should be sorted and comma separated.
 */


public class NumberWith123Digits {

    public static void main(String[] args){

        int[] nums = {231, 456, 267, 389, 999, 178, 321, 231};

        SolNumberWith123Digits s = new SolNumberWith123Digits();
        String result = s.NumberWith123DigitsBruteForce(nums);

        System.out.println("Result is : " + result);
    }

}


class SolNumberWith123Digits {

    // O(N)
    public String NumberWith123DigitsBruteForce(int[] arr){

        String result = "";
        boolean isFirst = true;

        for(int val : arr){

            String valStr = Integer.toString(val);
            if (valStr.contains("1") && valStr.contains("2") && valStr.contains("3")) {
                if(isFirst) {
                    result = result + valStr;
                    isFirst = false;
                } else {
                    result = result + ", "+ valStr;
                }
            }


        }

        return result;
    }

}
