package com.datastructures_algorithms.neetcode_150._1_25;

/**
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

 */
public class _2ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] charToIndexArr = new int[26];
        for(char c: s.toCharArray()){
            charToIndexArr[c - 'a']++;
        }
        for(char c: t.toCharArray()){
            if(charToIndexArr[c - 'a'] == 0)
                return false;
            else
                charToIndexArr[c - 'a']--;
        }
        for (int count : charToIndexArr) {
            if (count != 0)
                return false;
        }
        return true;
    }
}
