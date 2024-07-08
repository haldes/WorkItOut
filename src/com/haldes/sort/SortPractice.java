package com.haldes.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortPractice {
    public static List<Integer> sortList(List<Integer> unsortedList) {
        // WRITE YOUR BRILLIANT CODE HERE
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
