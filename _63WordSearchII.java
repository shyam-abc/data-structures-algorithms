package com.datastructures_algorithms.neetcode_150._3_25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _63WordSearchII {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, c -> new TrieNode());
            }
            node.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                backtrack(board, row, col, root, result);
            }
        }

        return result;
    }

    private void backtrack(char[][] board, int row, int col, TrieNode node, List<String> result) {
        char ch = board[row][col];
        if (ch == '#' || !node.children.containsKey(ch)) return;

        TrieNode nextNode = node.children.get(ch);

        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // Avoid duplicates
        }

        board[row][col] = '#';

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int dir = 0; dir < 4; dir++) {
            int newRow = row + dx[dir];
            int newCol = col + dy[dir];

            if (newRow >= 0 && newRow < board.length &&
                    newCol >= 0 && newCol < board[0].length) {
                backtrack(board, newRow, newCol, nextNode, result);
            }
        }

        board[row][col] = ch; // Unmark visited

        // Optimization: prune Trie node if no more children
        if (nextNode.children.isEmpty()) {
            node.children.remove(ch);
        }
    }
}
