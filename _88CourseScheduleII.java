package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
public class _88CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.putIfAbsent(prereq, new ArrayList<>());
            graph.get(prereq).add(course);

            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[idx++] = curr;

            if (graph.containsKey(curr)) {
                for (int neighbor : graph.get(curr)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        if (idx == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
