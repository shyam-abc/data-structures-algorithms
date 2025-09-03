package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class _112LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int str1Index = 1; str1Index <= len1; str1Index++){
            for(int str2Index = 1; str2Index <= len2; str2Index++){
                if(text1.charAt(str1Index - 1) == text2.charAt(str2Index - 1))
                    dp[str1Index][str2Index] = dp[str1Index - 1][str2Index - 1] + 1;
                else
                    dp[str1Index][str2Index] = Math.max(dp[str1Index - 1][str2Index], dp[str1Index][str2Index - 1]);
            }
        }
        return dp[len1][len2];
    }
}
