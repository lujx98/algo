package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-05-10
 */
public class Tree_q236_1_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val==root.val || q.val == root.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return root;
        }
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == p || root == q || root == null) {
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left != null && right != null) {
//            return root;
//        }
//        if (left == null && right != null) {
//            return right;
//        }
//        if (left != null & right == null) {
//            return left;
//        }
//        if (left == null && right == null) {
//            return null;
//        }
//        return null;
//    }

}
