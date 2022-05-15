package com.lu.algo.tree.bts;

/**
 * @author sheldon
 * @date 2022-05-15
 */
public class q538ConvertBST {

    public class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convertToBST(root);
        return root;
    }

    private void convertToBST(TreeNode root) {
        if (root == null) {
            return ;
        }
        convertToBST(root.right);
        sum += root.val;
        root.val = sum;
        convertToBST(root.left);
    }

}
