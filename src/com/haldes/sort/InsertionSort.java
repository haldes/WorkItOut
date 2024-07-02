package com.haldes.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InsertionSort {
    public static List<Integer> sortList(List<Integer> unsortedList) {
        // WRITE YOUR BRILLIANT CODE HERE

        for(int i = 0 ; i < unsortedList.size(); i++){
            int curr = i;
            while( curr > 0) {
                System.out.println(curr);
                if( unsortedList.get(curr) < unsortedList.get(curr - 1)) {
                    //swap
                    int temp = unsortedList.get(curr);
                    unsortedList.set(curr, unsortedList.get(curr - 1));
                    unsortedList.set(curr - 1 , temp);
                }

                curr --;
            }
            System.out.println(unsortedList);
            System.out.println("------------");

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
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(5,3,1,2,4));
        List<Integer> res = sortList(unsortedList);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
