package com.datastructures_algorithms.neetcode_150._4_25;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class _99ClimbStairs {
    public int climbStairs(int n) {
        if(n == 0 || n == 1)
            return 1;
        int prev2 = 1, prev1 = 1;
        for(int i = 2; i <= n; i++){
            int current = prev2 + prev1;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
