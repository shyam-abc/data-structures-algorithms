package com.datastructures_algorithms.neetcode_150._3_25;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class _59BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(maxPathSumHelper(node.left), 0);
        int rightGain = Math.max(maxPathSumHelper(node.right), 0);

        int currentPathSum = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }
}
