package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */
public class _113BestTimeToBuyAndSellStockCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] rest = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i-1], rest[i-1] - prices[i]);
            sell[i] = buy[i-1] + prices[i];
            rest[i] = Math.max(rest[i-1], sell[i-1]);
        }

        return Math.max(sell[n-1], rest[n-1]);
    }
}
