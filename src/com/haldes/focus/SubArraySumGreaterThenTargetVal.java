package com.haldes.focus;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 3. Given an array of non-negative numbers & a target value, return the length of
 * smallest subarray whose sum is greater than the target value.
 */

public class SubArraySumGreaterThenTargetVal {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 7, 6, 4};
        int target = 10;

        SolutionSubArraySumGreaterThenTargetVal s = new SolutionSubArraySumGreaterThenTargetVal();
        //ArrayList<Integer> result = s.SubArraySumGreaterThenTargetValBruteForce(nums, target);
        //System.out.println("Result : " + result.toString());
        int r = s.minSubArrayLen(nums, target);

        System.out.println("Result is : " + r);

    }

}

class SolutionSubArraySumGreaterThenTargetVal {

    public ArrayList<Integer> SubArraySumGreaterThenTargetValBruteForce(int[] arr, int t) {

        int currTotal = 0;

        boolean gotAns = false;

        ArrayList<Integer> l = new ArrayList<Integer>();


        for (int i = 0; i < arr.length; i++) {

            // if one element is equal to the target
            // Then clear the result and send only that variable
            if (arr[i] == t) {
                l.clear();
                l.add(arr[i]);
                break;
            }

            currTotal += arr[i];
            l.add(arr[i]);

            for (int j = i + 1; j < arr.length; j++) {

                if (currTotal + arr[j] == t) {
                    l.add(arr[j]);
                    gotAns = true;
                    break;
                }
            }

            if (gotAns) break;

        }

        return l;
    }

    public int minSubArrayLen(int[] nums, int s) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        int j = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;

        while (j < nums.length) {
            if (sum < s) {
                sum += nums[j];
                j++;
            } else {
                minLen = Math.min(minLen, j - i);
                if (i == j - 1)
                    return 1;

                sum -= nums[i];
                i++;
            }
        }

        while (sum >= s) {
            minLen = Math.min(minLen, j - i);

            sum -= nums[i++];
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


}
