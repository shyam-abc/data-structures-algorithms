package com.datastructures_algorithms.neetcode_150._5_25;

/**
 * https://leetcode.com/problems/gas-station/description/
 */
public class _125GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0, totalGas = 0, tank = 0, startIndex = 0;
        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                startIndex = i + 1;
                tank = 0;
            }
        }

        return totalGas < totalCost ? -1 : startIndex;
    }
}
