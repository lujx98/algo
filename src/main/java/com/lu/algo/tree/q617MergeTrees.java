package com.lu.algo.tree;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class q617MergeTrees {

    public class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.right = mergeTrees(root1.right, root2.right);
        root1.left = mergeTrees(root1.left, root2.left);
        return root1;
    }

}
