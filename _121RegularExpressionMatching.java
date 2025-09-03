package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class _121RegularExpressionMatching {
    public boolean isMatch(String s, String p){
        if (s == null || p == null)
            return false;

        int m = s.length(), n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                char sc = s.charAt(i - 1);

                if (pc == '.' || pc == sc) {
                    // direct match or '.'
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Zero occurrences of previous element
                    dp[i][j] = dp[i][j - 2];

                    // If previous pattern char matches current s char, we can
                    // "consume" s[i-1] and keep pattern (use '*' to match multiple)
                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // literal mismatch -> false (dp default is false)
                }
            }
        }

        return dp[m][n];
    }
}
