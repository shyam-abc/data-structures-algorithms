package com.datastructures_algorithms.neetcode_150._2_25;
/**
 https://leetcode.com/problems/same-tree/description/
 */
public class _50SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
