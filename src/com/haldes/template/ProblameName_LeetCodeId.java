package com.haldes.template;

/*
// LeetCode Id :
// Add Problem statement


*/

public class ProblameName_LeetCodeId {
    public static void main(String[] args) {

        long ans = 0L;
        Solution_ProblameName_LeetCodeId sol = new Solution_ProblameName_LeetCodeId();

        int[] nums1 = new int[]{7, 52, 2, 4};
        ans = sol.findTheArrayConcVal(nums1);
        System.out.println(ans);

        int[] nums2 = new int[]{5, 14, 13, 8, 12};
        ans = sol.findTheArrayConcVal(nums2);
        System.out.println(ans);

    }
}

/**
 * Input: nums = [7,52,2,4]
 * Output: 596
 */
class Solution_ProblameName_LeetCodeId {

    public long findTheArrayConcVal(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        long ans = 0L;

        while (l <= r) {
            if (l == r) {
                ans += Long.parseLong(String.valueOf(nums[l]));
            } else {
                ans += Long.parseLong(String.valueOf(nums[l]) + String.valueOf(nums[r]));
            }
            l++;
            r--;
        }

        return ans;
    }

}
