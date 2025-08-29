package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/description/
 */
public class _92WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;  // endWord must be in dict

        // Preprocessing: build pattern map
        Map<String, List<String>> patternMap = new HashMap<>();
        int L = beginWord.length();

        for (String word : wordSet) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // BFS queue: (word, level)
        Queue<AbstractMap.SimpleEntry<String, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<String, Integer> entry = queue.poll();
            String word = entry.getKey();
            int level = entry.getValue();

            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);

                for (String neighbor : patternMap.getOrDefault(pattern, new ArrayList<>())) {
                    if (neighbor.equals(endWord)) {
                        return level + 1; // found the shortest path
                    }
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(new AbstractMap.SimpleEntry<>(neighbor, level + 1));
                    }
                }
            }
        }
        return 0; // no path
    }
}
