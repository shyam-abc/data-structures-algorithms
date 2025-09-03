package com.datastructures_algorithms.neetcode_150._5_25;

/**
 *https://leetcode.com/problems/jump-game/description/
 */
public class _123JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > farthest)
                return false; // stuck

            farthest = Math.max(farthest, i + nums[i]);

            if (farthest >= n - 1)
                return true; // can reach end
        }

        return true;
    }

    public boolean canJumpDP(int[] nums){
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break; // no need to check further
                }
            }
        }

        return dp[n - 1];
    }
}
