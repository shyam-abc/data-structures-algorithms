package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.HashMap;
import java.util.Map;

/**
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

 */
public class _19MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";

        Map<Character, Integer> freqMapT = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            freqMapT.put(t.charAt(i), freqMapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int required = freqMapT.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (freqMapT.containsKey(c) && windowCounts.get(c).intValue() == freqMapT.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (freqMapT.containsKey(leftChar) && windowCounts.get(leftChar) < freqMapT.get(leftChar)) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
