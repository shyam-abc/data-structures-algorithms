package com.datastructures_algorithms.neetcode_150._2_25;

/**
https://leetcode.com/problems/invert-binary-tree/
 */
public class _46InvertBinaryTree {
    public TreeNode invertTree(TreeNode root){
        if(root == null)
            return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
