package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.*;

/**
 Given an array of strings strs, group the anagrams together. You can return the answer in any order.



 Example 1:

 Input: strs = ["eat","tea","tan","ate","nat","bat"]

 Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

 Explanation:

 There is no string in strs that can be rearranged to form "bat".
 The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 Example 2:

 Input: strs = [""]

 Output: [[""]]

 Example 3:

 Input: strs = ["a"]

 Output: [["a"]]
 */
public class _4GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringListMap = new HashMap<>();
        int[] countArr = new int[26];
        for(String str: strs){
            Arrays.fill(countArr, 0);
            for(char c: str.toCharArray()){
                countArr[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                sb.append("#");
                sb.append(countArr[i]);
            }
            String key = sb.toString();
            if(!stringListMap.containsKey(key)){
                stringListMap.put(key, new ArrayList<>());
            }
            stringListMap.get(key).add(str);
        }
        return new ArrayList<>(stringListMap.values());
    }
}
