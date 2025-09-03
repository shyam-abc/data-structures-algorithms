package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/edit-distance/description/
 */
public class _119EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],            // delete
                            Math.min(dp[i][j - 1],   // insert
                                    dp[i - 1][j - 1]) // replace
                    );
                }
            }
        }

        return dp[m][n];
    }

    public int minDistanceOptimised(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // Base case: dp[0][j] = j
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = i; // dp[i][0] = i (need i deletions)

            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1]; // no operation
                } else {
                    curr[j] = 1 + Math.min(
                            prev[j],          // delete
                            Math.min(curr[j - 1],  // insert
                                    prev[j - 1])   // replace
                    );
                }
            }

            // Move curr into prev
            prev = curr.clone();
        }

        return prev[n];
    }
}
