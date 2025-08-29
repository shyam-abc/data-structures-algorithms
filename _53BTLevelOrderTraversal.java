package com.datastructures_algorithms.neetcode_150._3_25;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class _53BTLevelOrderTraversal {
    List<List<Integer>> ans = new ArrayList<>();
    public void levelOrderHelper(TreeNode node, int level){
        if(ans.size() == level)
            ans.add(new ArrayList<>());

        ans.get(level).add(node.val);

        if(node.left != null)
            levelOrderHelper(node.left, level + 1);
        if(node.right != null)
            levelOrderHelper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return ans;
        levelOrderHelper(root, 0);
        return ans;
    }
}
