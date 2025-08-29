package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 */
public class _93ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build graph: airport -> min-heap of destinations
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll(); // pick smallest lexical destination
            dfs(next, graph, itinerary);
        }
        // Add airport after exploring all outgoing edges
        itinerary.addFirst(airport);
    }
}
