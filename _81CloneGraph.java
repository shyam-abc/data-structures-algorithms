package com.datastructures_algorithms.neetcode_150._4_25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/clone-graph/description/
 */
public class _81CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        if(visited.containsKey(node))
            return visited.get(node);

        Node clonedNode = new Node(node.val, new ArrayList<>());
        visited.put(node, clonedNode);
        for(Node neighbour: node.neighbors)
            clonedNode.neighbors.add(cloneGraph(neighbour));

        return clonedNode;
    }
}
