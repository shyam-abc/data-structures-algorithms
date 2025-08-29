package com.datastructures_algorithms.neetcode_150._2_25;

/**
 https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class _47MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth((root.right)));
    }
}
