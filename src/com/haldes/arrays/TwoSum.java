package com.haldes.arrays;

import java.util.Arrays;
import java.util.HashMap;

/*
1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

public class TwoSum {

    public static void main(String[] args) {

        System.out.println("Hello TwoSum !!!");

        int[] nums = {3, 2, 4, 8, 9};
        int target = 10;
        int[] ret = new int[2];

        SolutionBruteForce sol = new SolutionBruteForce();
        int[] result = sol.twoSum(nums, target);
        System.out.println("The result Brute force O(N^2)" + Arrays.toString(result));

        SolutionMapBased solMp = new SolutionMapBased();
        int[] resultMap = solMp.twoSum(nums, target);
        System.out.println("The result Map based O(N)" + Arrays.toString(resultMap));


    }


}

class SolutionMapBased {

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];

        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            if (hmap.containsKey(nums[i])) {
                ret[0] = i;
                ret[1] = hmap.get(nums[i]);
            } else {
                //System.out.println(target-nums[i]+"--------"+i);
                hmap.put(target-nums[i],i);
            }


        }

        return ret;
    }


}

class SolutionBruteForce {
    public int[] twoSum(int[] nums, int target) {

        int[] ret = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }

            }

        }


        return ret;
    }
}
