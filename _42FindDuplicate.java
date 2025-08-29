package com.datastructures_algorithms.neetcode_150._2_25;

/**
 https://leetcode.com/problems/find-the-duplicate-number/
 */
public class _42FindDuplicate {
    public int findDuplicate(int[] nums){
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}
