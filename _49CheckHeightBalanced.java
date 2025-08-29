package com.datastructures_algorithms.neetcode_150._2_25;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class _49CheckHeightBalanced {
    public boolean isBalanced(TreeNode root) {
        return getHeightIfBalanced(root) != -1;
    }

    private int getHeightIfBalanced(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeightIfBalanced(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = getHeightIfBalanced(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
