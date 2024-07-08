package com.haldes.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BinarySearch {
    public static int binarySearch(List<Integer> arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        System.out.println(arr);
        int left = 0;
        int right = arr.size() - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("left : "+ left + " right: "+ right + " mid: "+ mid);

            if (arr.get(mid) == target) return mid;
            if (arr.get(mid) < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();*/
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,3,5,7,8));
        int target = 8;
        int res = binarySearch(arr, target);
        System.out.println(res);
    }
}
