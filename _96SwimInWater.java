package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.PriorityQueue;

/**
 *https://leetcode.com/problems/swim-in-rising-water/description/
 */
public class _96SwimInWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // Directions: up, down, left, right
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Min-heap: [timeRequired, row, col]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];

        // Start at (0,0), time required is its elevation
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int timeRequired = current[0];
            int row = current[1];
            int col = current[2];

            // If we've reached the bottom-right, return answer
            if (row == n - 1 && col == n - 1) {
                return timeRequired;
            }

            if (visited[row][col]) continue;
            visited[row][col] = true;

            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    int newTime = Math.max(timeRequired, grid[newRow][newCol]);
                    minHeap.offer(new int[]{newTime, newRow, newCol});
                }
            }
        }

        return -1; // should never reach here if input is valid
    }
}
