package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class _122MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
