package com.datastructures_algorithms.neetcode_150._3_25;

import java.util.*;

/**
 * https://leetcode.com/problems/task-scheduler/description/
 */
public class _68TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char t : tasks) {
            freqMap.put(t, freqMap.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freqMap.values());

        int time = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            for(int i = 0; i < cycle; i++){
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.poll());
                }
            }

            for(int freq: temp){
                if(--freq > 0){
                    maxHeap.add(freq);
                }
            }

            time += maxHeap.isEmpty() ? temp.size() : cycle;
        }

        return time;
    }
}
