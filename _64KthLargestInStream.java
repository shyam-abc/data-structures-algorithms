package com.datastructures_algorithms.neetcode_150._3_25;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */
public class _64KthLargestInStream {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public _64KthLargestInStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        } else if(val > minHeap.peek()){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
