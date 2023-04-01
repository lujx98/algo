package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-05-12
 */
public class Tree_q701_1_InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode treeNode = new TreeNode(val);
            return treeNode;
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left,val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }

//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root == null) {
//            return new TreeNode(val);
//        }
//        if (root.val > val) {
//            root.left = insertIntoBST(root.left, val);
//        }
//        if (root.val < val) {
//            root.right = insertIntoBST(root.right, val);
//        }
//        return root;
//    }

}
