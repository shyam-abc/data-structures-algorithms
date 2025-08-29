package com.datastructures_algorithms.neetcode_150._1_25;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 https://leetcode.com/problems/sliding-window-maximum/description/
 You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 Return the max sliding window.

 Example 1:

 Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 Output: [3,3,5,5,6,7]
 Explanation:
 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]

 */
public class _20SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0)
            return new int[0];

        Deque<Integer> currMaximumQueue = new ArrayDeque<>(k);
        int[] resultList = new int[nums.length - k + 1];

        for(int right = 0; right < nums.length; right++){
            if (!currMaximumQueue.isEmpty() && currMaximumQueue.peekFirst() < right - k + 1) {
                currMaximumQueue.pollFirst();
            }
            while (!currMaximumQueue.isEmpty() && nums[currMaximumQueue.peekLast()] < nums[right]) {
                currMaximumQueue.pollLast();
            }
            currMaximumQueue.offerLast(right);
            if (right >= k - 1) {
                resultList[right - k + 1] = nums[currMaximumQueue.peekFirst()];
            }
        }
        return Arrays.stream(resultList).toArray();
    }
}
