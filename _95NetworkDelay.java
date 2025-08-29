package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/description/
 */
public class _95NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int startNode) {
        // Step 1: Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            int source = edge[0];
            int target = edge[1];
            int travelTime = edge[2];
            graph.computeIfAbsent(source, x -> new ArrayList<>())
                    .add(new int[]{target, travelTime});
        }

        // Step 2: Distance array, initially infinity
        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[startNode] = 0;

        // Step 3: Min-heap for [time, node]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, startNode});

        // Step 4: Dijkstra’s algorithm
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentTime = current[0];
            int currentNode = current[1];

            // Skip if we already found a better path
            if (currentTime > minTime[currentNode])
                continue;

            // Explore neighbors
            if (graph.containsKey(currentNode)) {
                for (int[] neighbor : graph.get(currentNode)) {
                    int nextNode = neighbor[0];
                    int travelTime = neighbor[1];
                    int newTime = currentTime + travelTime;

                    if (newTime < minTime[nextNode]) {
                        minTime[nextNode] = newTime;
                        minHeap.offer(new int[]{newTime, nextNode});
                    }
                }
            }
        }

        // Step 5: Find maximum time to reach all nodes
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) {
                return -1; // unreachable node
            }
            maxTime = Math.max(maxTime, minTime[i]);
        }

        return maxTime;
    }
}
