package com.lu.algo.tree.bts;

/**
 * @author sheldon
 * @date 2022-05-15
 */
public class q669TrimBST {

    public class TreeNode {
        public TreeNode right ;
        public TreeNode left;
        public int val;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        //todo:没做出来
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            return trimBST(root.left,low,high);
        }
        if (root.val < low) {
            return trimBST(root.right,low,high);
        }
        root.right = trimBST(root.right,low,high);
        root.left = trimBST(root.left,low,high);
        return root;
    }

}
