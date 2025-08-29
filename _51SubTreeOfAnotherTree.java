package com.datastructures_algorithms.neetcode_150._3_25;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class _51SubTreeOfAnotherTree {
    public boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.val != root2.val)
            return false;

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        if(isSameTree(root, subRoot))
            return true;

        return isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
    }
}
