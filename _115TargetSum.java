package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/target-sum/description/
 */
public class _115TargetSum {
    public int findTargetSumWays(int[] nums, int target){
        int total = 0;

        for (int n : nums)
            total += n;

        if ((target + total) % 2 != 0 || Math.abs(target) > total)
            return 0;

        int subsetSum = (target + total) / 2;

        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int currSum = subsetSum; currSum >= num; currSum--) {
                dp[currSum] += dp[currSum - num];
            }
        }

        return dp[subsetSum];
    }
}
