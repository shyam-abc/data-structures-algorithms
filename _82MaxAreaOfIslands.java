package com.datastructures_algorithms.neetcode_150._4_25;

/**
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class _82MaxAreaOfIslands {
   public int maxAreaOfIsland(int[][] grid) {
        int rows, cols;
        rows = grid.length;
        cols = grid[0].length;

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid, rows, cols));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int r, int c, int[][] grid, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int area = 1;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int[] dir : directions) {
            area += dfs(r + dir[0], c + dir[1], grid, rows, cols);
        }

        return area;
    }
}
