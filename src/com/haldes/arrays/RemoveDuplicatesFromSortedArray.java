package com.haldes.arrays;

/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/


public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args){
        System.out.println("Hello RemoveDuplicatesFromSortedArray !!!");

        int[] nums  = {1,1,2};

        Solution sol = new Solution();

        int result =  sol.removeDuplicates(nums);

        System.out.println("Result : "+ result);

    }

}


class Solution {
    public int removeDuplicates(int[] nums) {

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == nums[i+1] || nums[i] == 0){
                nums[i+1] = 0;
            }
        }

        return 0;
    }
}