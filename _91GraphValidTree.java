package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.*;

/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 */
public class _91GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // Rule 1: check edge count
        if (edges.length != n - 1)
            return false;

        // Build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Visited set
        Set<Integer> visited = new HashSet<>();

        // DFS from node 0
        if (!dfs(0, -1, graph, visited))
            return false;

        // Check connectivity
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node))
            return false; // cycle detected

        visited.add(node);

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent)
                continue; // skip the edge to parent
            if (!dfs(neighbor, node, graph, visited))
                return false;
        }

        return true;
    }
}
