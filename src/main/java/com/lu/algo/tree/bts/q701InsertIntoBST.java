package com.lu.algo.tree.bts;

import lombok.Data;

/**
 * @author sheldon
 * @date 2022-05-12
 */
public class q701InsertIntoBST {


    public class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        public int val;
        public TreeNode right;
        public TreeNode left;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
