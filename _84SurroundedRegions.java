package com.datastructures_algorithms.neetcode_150._4_25;

/**
 * https://leetcode.com/problems/surrounded-regions/description/
 */
public class _84SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);           // first column
            dfs(board, i, cols - 1);    // last column
        }
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);           // first row
            dfs(board, rows - 1, j);    // last row
        }

        // 2. Flip all remaining 'O' -> 'X', and 'S' -> 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // captured
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';  // restore safe
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        // boundary + only process 'O'
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'S'; // mark safe
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] direction: directions){
            int neighbourRow = i + direction[0];
            int neighbourCol = j + direction[1];
            dfs(board, neighbourRow, neighbourCol);
        }
    }
}
