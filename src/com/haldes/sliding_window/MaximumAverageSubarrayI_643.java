package com.haldes.sliding_window;

/*
// LeetCode Id :
// Add Problem statement


*/

public class MaximumAverageSubarrayI_643 {
    public static void main(String[] args) {

        double ans = 0L;
        Solution_MaximumAverageSubarrayI_643 sol = new Solution_MaximumAverageSubarrayI_643();

        int[] nums1 = new int[]{1,12,-5,-6,50,3};
        ans = sol.findMaxAverage(nums1, 4);
        System.out.println(ans);
//
//        int[] nums2 = new int[]{5, 14, 13, 8, 12};
//        ans = sol.findTheArrayConcVal(nums2);
//        System.out.println(ans);

    }
}

/**
 * Input: nums = [7,52,2,4]
 * Output: 596
 */
class Solution_MaximumAverageSubarrayI_643 {

    public double findMaxAverage(int[] nums, int k) {

        double curr = 0;
        double ans = 0;

        // Input: nums = [1,12,-5,-6,50,3], k = 4
        // created the first window [1,12,-5,-6]
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        ans = curr / k;
        System.out.println(ans);

        for (int i = k; i < nums.length; i++) {
            curr -= nums[i - k]; // k=4 - i=3 ==>1 i.e. remove nums[1]
            curr += nums[i];
            ans = Math.max(ans, curr / k);
        }

        return ans;
    }

}
