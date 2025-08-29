package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.*;

/**
 * Alien Dictionary
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 * You are given a list of strings words from the dictionary, where the strings in words are sorted lexicographically by the rules of this new language.
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order according to the new language’s rules.
 * If there is no solution, return "".
 * If there are multiple valid solutions, return any of them.
 * Example 1
 * Input:
 * words = ["wrt","wrf","er","ett","rftt"]
 * Output:
 * "wertf"
 */
public class _97AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for(String word: words){
            for(char c: word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int minLen = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while(!queue.isEmpty()){
            char c = queue.poll();
            result.append(c);

            for(char neighbour: graph.get(c)){
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                if(inDegree.get(neighbour) == 0){
                    queue.offer(neighbour);
                }
            }
        }

        if (result.length() < inDegree.size()) {
            return "";
        }

        return result.toString();
    }
}
