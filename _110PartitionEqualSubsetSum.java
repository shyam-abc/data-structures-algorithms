package com.datastructures_algorithms.neetcode_150._5_25;

/**
 *https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class _110PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums)
            total += num;

        if (total % 2 != 0)
            return false;

        int target = total / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean notPick = dp[i-1][t];
                boolean pick = false;
                if (nums[i] <= t) {
                    pick = dp[i-1][t - nums[i]];
                }
                dp[i][t] = pick || notPick;
            }
        }

        return dp[n-1][target];
    }

    public boolean canPartitionOptimised(int[] nums){
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0)
            return false;

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int t = target; t >= num; t--) {
                if(dp[t - num])
                    dp[t] = true;
            }
        }
        return dp[target];
    }
}
