package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given m x n grid, -1 -> wall, 0 -> gate, INF -> empty room
 * fill each empty room with distance to nearest gate, if impossible fill as INF
 */
public class _86WallsAndGates {
    private static final int INF = Integer.MAX_VALUE;
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];

            for (int[] dir : DIRS) {
                int r = row + dir[0], c = col + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != INF) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }
}
