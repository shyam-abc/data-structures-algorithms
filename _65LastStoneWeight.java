package com.datastructures_algorithms.neetcode_150._3_25;

import java.util.Collections;
import java.util.PriorityQueue;


/**
 * https://leetcode.com/problems/last-stone-weight/description/
 */
public class _65LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones)
            maxHeap.offer(stone);

        while (maxHeap.size() > 1) {
            int heaviestStone = maxHeap.poll();
            int secondHeaviestStone = maxHeap.poll();

            if (heaviestStone != secondHeaviestStone) {
                maxHeap.offer(heaviestStone - secondHeaviestStone);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
