package com.lu.algo.tree;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class q112HasPathSum {

    public class TreeNode {
        public int val;
        public TreeNode right;
        public TreeNode left;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.right == null && root.left == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum, root.val) || hasPathSum(root.right, targetSum, root.val);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int current) {
        if (root == null) {
            return false;
        }
        current += root.val;
        if (root.left == null && root.right == null) {
            return current == targetSum;
        }
        return hasPathSum(root.left, targetSum, current) || hasPathSum(root.right, targetSum, current);
    }


}
