package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 */
public class _83PacificAtlanticWaterFlow {
    private int rows, cols;
    private int[][] heights;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top row & left column
        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacific);
            dfs(rows - 1, c, atlantic);
        }
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific);
            dfs(r, cols - 1, atlantic);
        }

        // Collect cells reachable by both
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited) {
        if (visited[r][c])
            return;
        visited[r][c] = true;

        for (int[] direction : directions) {
            int neighbourRow = r + direction[0];
            int neighbourCol = c + direction[1];
            // Move inward only if:
            // 1. Inside bounds
            // 2. Neighbor height >= current height (reverse flow logic)
            if (neighbourRow >= 0 && neighbourRow < rows && neighbourCol >= 0 && neighbourCol < cols &&
                    heights[neighbourRow][neighbourCol] >= heights[r][c]) {
                dfs(neighbourRow, neighbourCol, visited);
            }
        }
    }
}
