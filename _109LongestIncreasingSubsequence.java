package com.datastructures_algorithms.neetcode_150._5_25;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.binarySearch;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class _109LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int lislength = 1;
        for(int currIndex = 1; currIndex < nums.length; currIndex++){
            for(int prevIndex = 0; prevIndex < currIndex; prevIndex++){
                if(nums[currIndex] > nums[prevIndex]){
                    lis[currIndex] = Math.max(lis[currIndex], lis[prevIndex] + 1);
                    lislength = Math.max(lislength, lis[currIndex]);
                }
            }
        }
        return lislength;
    }

    public int lengthOfLISOptimal(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int index = 1; index < nums.length; index++) {
            if (nums[index] > sub.get(sub.size() - 1)) {
                sub.add(nums[index]);
            } else {
                int idxFirstGreaterVal = binarySearch(sub, nums[index]);
                if (idxFirstGreaterVal < 0)
                    idxFirstGreaterVal = -(idxFirstGreaterVal + 1);
                sub.set(idxFirstGreaterVal, nums[index]);
            }
        }
        return sub.size();
    }

}
