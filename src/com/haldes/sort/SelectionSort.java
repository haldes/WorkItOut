package com.haldes.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectionSort {
    public static List<Integer> sortList(List<Integer> unsortedList) {
        // WRITE YOUR BRILLIANT CODE HERE
        for(int i = 0; i < unsortedList.size(); i++){
            System.out.println("=====> " + i);
            int swpIndex = -1;
            int min = Integer.MAX_VALUE;
            for(int j=i ; j < unsortedList.size() ; j++) {
                System.out.println(j);
                if(unsortedList.get(j) < min) {
                    min = unsortedList.get(j);
                    swpIndex = j;
                }
            }
            // swap
            if(swpIndex > 0) {
                int temp = unsortedList.get(i);
                unsortedList.set(i, unsortedList.get(swpIndex));
                unsortedList.set(swpIndex, temp);
            }
            System.out.println("--------------");
        }

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
