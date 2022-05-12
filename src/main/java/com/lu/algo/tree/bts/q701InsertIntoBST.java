package com.lu.algo.tree.bts;

/**
 * @author sheldon
 * @date 2022-05-12
 */
public class q701InsertIntoBST {

    public class TreeNode {
        public int val;
        public TreeNode right;
        public TreeNode left;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {

        }
        if (root.val > val) {
            insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            insertIntoBST(root.right, val);
        }
        return root;
    }

}
