package com.datastructures_algorithms.neetcode_150._4_25;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class _100MinCostClimbStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1)
            return cost[0];
        if(cost.length == 2)
            return Math.min(cost[0], cost[1]);

        int prev2 = cost[0], prev1 = cost[1];

        for(int i = 2; i <= cost.length; i++){
            int current = Math.min(prev2, prev1) + cost[i];
            prev2 = prev1;
            prev1 = current;
        }

        return Math.min(prev2, prev1);
    }
}
