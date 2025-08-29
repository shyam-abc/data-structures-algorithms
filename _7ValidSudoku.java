package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.HashSet;
import java.util.Set;

/**
 Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 */
public class _7ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.')
                    continue;

                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r].contains(ch) || cols[c].contains(ch) || boxes[boxIndex].contains(ch))
                    return false;

                rows[r].add(ch);
                cols[c].add(ch);
                boxes[boxIndex].add(ch);
            }
        }
        return true;
    }
}
