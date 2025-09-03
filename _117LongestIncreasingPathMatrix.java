package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 */
public class _117LongestIncreasingPathMatrix {
    private int m, n;
    private int[][] matrix;
    private int[][] dp;
    private final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        if (dp[i][j] != 0)
            return dp[i][j];

        int best = 1;
        for (int[] d : DIRS) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
                best = Math.max(best, 1 + dfs(ni, nj));
            }
        }
        dp[i][j] = best;
        return best;
    }
}
