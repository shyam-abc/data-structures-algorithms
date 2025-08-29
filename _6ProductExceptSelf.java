package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.Arrays;

/**
 Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

 The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 You must write an algorithm that runs in O(n) time and without using the division operation.

 Example 1:

 Input: nums = [1,2,3,4]
 Output: [24,12,8,6]
 Example 2:

 Input: nums = [-1,1,0,-3,3]
 Output: [0,0,9,0,0]
 */
public class _6ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int preFixProduct = 1, postFixProduct = 1;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for(int start = 0; start < nums.length; start++){
            result[start] = preFixProduct;
            preFixProduct = preFixProduct * nums[start];
        }

        for(int end = nums.length - 1; end >= 0; end--){
            result[end] = result[end] * postFixProduct;
            postFixProduct = postFixProduct * nums[end];
        }
        return result;
    }
}
