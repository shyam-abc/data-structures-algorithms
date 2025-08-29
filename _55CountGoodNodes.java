package com.datastructures_algorithms.neetcode_150._3_25;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class _55CountGoodNodes {
    public int goodNodes(TreeNode root) {
        int[] good = new int[1];
        dfs(root, root.val, good);
        return good[0];
    }

    private void dfs(TreeNode node, int maxSoFar, int[] good) {
        if (node == null)
            return;

        if (node.val >= maxSoFar)
            good[0]++;

        maxSoFar = Math.max(maxSoFar, node.val);

        dfs(node.left, maxSoFar, good);
        dfs(node.right, maxSoFar, good);
    }
}
