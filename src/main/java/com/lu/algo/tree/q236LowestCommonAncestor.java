package com.lu.algo.tree;

/**
 * @author sheldon
 * @date 2022-05-10
 */
public class q236LowestCommonAncestor {

    public class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left != null & right == null) {
            return left;
        }
        if (left == null && right == null) {
            return null;
        }
        return null;
    }

}
