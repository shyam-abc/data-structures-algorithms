package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.PriorityQueue;

/**
 *https://leetcode.com/problems/min-cost-to-connect-all-points/description/
 */
public class _94MinCostConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inMST = new boolean[n];
        int mstCost = 0;
        int connectedPoints = 0;

        // Min-heap storing [edgeCost, pointIndex]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0}); // start from point 0 with cost 0

        while (connectedPoints < n) {
            int[] top = minHeap.poll();
            int edgeCost = top[0];
            int pointIndex = top[1];

            if (inMST[pointIndex])
                continue; // skip if already added

            // Add this point to MST
            inMST[pointIndex] = true;
            mstCost += edgeCost;
            connectedPoints++;

            // Push all possible edges from this point to the heap
            for (int nextIndex = 0; nextIndex < n; nextIndex++) {
                if (!inMST[nextIndex]) {
                    int manhattanDist = Math.abs(points[pointIndex][0] - points[nextIndex][0]) +
                            Math.abs(points[pointIndex][1] - points[nextIndex][1]);
                    minHeap.offer(new int[]{manhattanDist, nextIndex});
                }
            }
        }

        return mstCost;
    }
}
