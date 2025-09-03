package com.datastructures_algorithms.neetcode_150._5_25;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/description/
 */
public class _111UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp)
            Arrays.fill(row, 1);

        for(int rowIndex = 1; rowIndex < m; rowIndex++){
            for(int colIndex = 1; colIndex < n; colIndex++){
                dp[rowIndex][colIndex] = dp[rowIndex - 1][colIndex] + dp[rowIndex][colIndex - 1];
            }
        }

        return dp[m-1][n-1];
    }
}
