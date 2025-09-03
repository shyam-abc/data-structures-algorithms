package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/distinct-subsequences/description/
 */
public class _118DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        // dp[i][j] = ways to form t[0..j-1] from s[0..i-1]
        long[][] dp = new long[m + 1][n + 1];

        // Base case: empty t
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return (int) dp[m][n];
    }

    public int numDistinctOptimised(String s, String t) {
        int m = s.length(), n = t.length();
        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        prev[0] = 1;

        for (int i = 1; i <= m; i++) {
            curr[0] = 1;

            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }

            prev = curr.clone();
        }

        return (int) prev[n];
    }
}
