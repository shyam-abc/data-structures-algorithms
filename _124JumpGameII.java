package com.datastructures_algorithms.neetcode_150._5_25;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/description/
 */
public class _124JumpGameII {
    public int jump(int[] nums){
        int jump = 0, currMax = 0, currEnd = 0;
        for(int i = 0; i < nums.length; i++){
            currMax = Math.max(currMax, i + nums[i]);
            if(i == currEnd){
                currEnd = currMax;
                jump++;
            }
        }
        return jump;
    }

    public int jumpDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
