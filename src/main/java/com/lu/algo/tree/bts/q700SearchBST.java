package com.lu.algo.tree.bts;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class q700SearchBST {

    public class TreeNode{
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left,val);
        } else if (root.val<val) {
            return searchBST(root.right,val);
        }
        return root;
    }

}
