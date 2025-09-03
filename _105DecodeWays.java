package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class _105DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }
            int two = Integer.parseInt(s.substring(i-2, i));
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
