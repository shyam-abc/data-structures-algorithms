package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
public class _106CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = amount + 1;

        int[][] dp = new int[n + 1][amount + 1];

        for (int coinIndex = 0; coinIndex <= n; coinIndex++) {
            dp[coinIndex][0] = 0;
        }

        for (int targetAmount = 1; targetAmount <= amount; targetAmount++) {
            dp[0][targetAmount] = INF;
        }

        for (int coinIndex = 1; coinIndex <= n; coinIndex++) {
            int coinValue = coins[coinIndex - 1];
            for (int targetAmount = 1; targetAmount <= amount; targetAmount++) {
                if (targetAmount < coinValue) {
                    dp[coinIndex][targetAmount] = dp[coinIndex - 1][targetAmount];
                } else {
                    dp[coinIndex][targetAmount] = Math.min(
                            dp[coinIndex - 1][targetAmount],                 // skip
                            1 + dp[coinIndex][targetAmount - coinValue]      // take
                    );
                }
            }
        }

        return dp[n][amount] >= INF ? -1 : dp[n][amount];
    }

    public int coinChangeSpaceOptimised(int[] coins, int amount) {
        int INF = amount + 1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int amt = 1; amt <= amount; amt++)
            dp[amt] = INF;

        for (int coin : coins) {
            for (int amt = coin; amt <= amount; amt++) {
                dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
            }
        }

        return dp[amount] >= INF ? -1 : dp[amount];
    }
}
