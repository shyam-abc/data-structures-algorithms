package com.datastructures_algorithms.neetcode_150._3_25;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 */
public class _62DesignAddSearchWords {
    private final TrieNode root;

    public _62DesignAddSearchWords() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            for (TrieNode child : node.children.values()) {
                if (dfsSearch(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode next = node.children.get(ch);
            return next != null && dfsSearch(word, index + 1, next);
        }
    }
}
