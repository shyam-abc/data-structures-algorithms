package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class _103LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String longest = "";

        for(int length = 1; length <= n; length++){
            for(int startIndex = 0; startIndex + length - 1 < n; startIndex++){
                int endIndex = startIndex + length - 1;

                if(length == 1)
                    dp[startIndex][endIndex] = true;
                else if(length == 2)
                    dp[startIndex][endIndex] = (s.charAt(startIndex) == s.charAt(endIndex));
                else
                    dp[startIndex][endIndex] = (s.charAt(startIndex) == s.charAt(endIndex)) &&
                                                    dp[startIndex+1][endIndex-1];

                if (dp[startIndex][endIndex] && length > longest.length()) {
                    longest = s.substring(startIndex, endIndex + 1);
                }
            }
        }
        return longest;
    }
}
