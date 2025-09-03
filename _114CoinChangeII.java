package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/coin-change-ii/description/
 */
public class _114CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int coin: coins){
            for(int nextCoin = coin; nextCoin <= amount; nextCoin++){
                dp[nextCoin] += dp[nextCoin - coin];
            }
        }

        return dp[amount];
    }
}
