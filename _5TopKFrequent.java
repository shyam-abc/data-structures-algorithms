package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.*;

/**
 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]

 */
public class _5TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k)
            return nums;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(countMap::get)
        );

        for(int num: countMap.keySet()){
            heap.add(num);
            if(heap.size() > k)
                heap.poll();
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++)
            ans[i] = heap.poll();

        return ans;
    }
}
