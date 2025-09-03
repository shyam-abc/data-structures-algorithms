package com.datastructures_algorithms.neetcode_150._5_25;


public class _104CountPalindSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

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

                if (dp[startIndex][endIndex]) {
                    count++;
                }
            }
        }
        return count;
    }
}
