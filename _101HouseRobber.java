package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class _101HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
