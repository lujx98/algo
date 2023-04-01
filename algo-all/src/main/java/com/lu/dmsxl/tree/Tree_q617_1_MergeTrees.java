package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class Tree_q617_1_MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;


        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }

//
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 == null) {
//            return root1;
//        }
//        travesal(root1.left, root2.left);
//        travesal(root1.left, root2.left);
//        return root1;
//    }
//
//    public void travesal(TreeNode root1, TreeNode root2) {
//        if (root2 == null) {
//            return;
//        }
//
//        root1.val += root2.val;
//
//        if (root1.left == null && root2.left != null) {
//            root1.left = new TreeNode(0);
//        }
//        travesal(root1.left, root2.left);
//        if (root1.right == null && root2.right != null) {
//            root1.right = new TreeNode(0);
//        }
//        travesal(root1.right, root2.right);
//
//    }

}
