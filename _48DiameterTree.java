package com.datastructures_algorithms.neetcode_150._2_25;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class _48DiameterTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return diameter;
    }

    private int diameterOfBinaryTreeHelper(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = diameterOfBinaryTreeHelper(node.left);
        int rightDepth = diameterOfBinaryTreeHelper(node.right);

        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
