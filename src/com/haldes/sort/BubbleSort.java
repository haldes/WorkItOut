package com.haldes.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
    public static List<Integer> sortList(List<Integer> unsortedList) {
        // WRITE YOUR BRILLIANT CODE HERE
        for(int i = unsortedList.size() - 1 ; i >= 0 ; i--){
            System.out.println("===> " + i);
            int swapIdx = -1;
            for(int j = 0 ; j < i; j++) {
                System.out.println(j);
                if(unsortedList.get(j) > unsortedList.get(j+1)){
                    // swap
                    int temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j+1));
                    unsortedList.set(j+1, temp);
                }
            }
            System.out.println("-----------");
        }

        System.out.println("=========Final Result===========");
        return unsortedList;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
    /*    Scanner scanner = new Scanner(System.in);
        List<Integer> unsortedList = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();*/
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(6,5,3,8,1,2,4,9));
        //List<Integer> unsortedList = new ArrayList<>(Arrays.asList(5,3,1,2,4));
        List<Integer> res = sortList(unsortedList);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
