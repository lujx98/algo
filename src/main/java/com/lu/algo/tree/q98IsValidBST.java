package com.lu.algo.tree;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class q98IsValidBST {

    public class TreeNode{
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root.left,root.val)&&isValidBST(root.right,root.val);
    }

    private boolean isValidBST(TreeNode root, int val) {
        //todo
        if (root == null) {
            return true;
        }
        return (root.left==null?true:root.left.val<root.val)&&(root.right==null?true:root.right.val>root.val)&&(root.right==null?true:root.right.val<val);
    }

}
