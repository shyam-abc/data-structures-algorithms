package com.datastructures_algorithms.neetcode_150._5_25;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 */
public class _108WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> wordDictSet = new HashSet<>(wordDict);
        for(int wordIndex = 1; wordIndex <= s.length(); wordIndex++){
            for(int prevIndex = 0; prevIndex < wordIndex; prevIndex++){
                if(dp[prevIndex] && wordDictSet.contains(s.substring(prevIndex, wordIndex))){
                    dp[wordIndex] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
