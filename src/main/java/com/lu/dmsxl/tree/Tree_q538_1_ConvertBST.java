package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-05-15
 */
public class Tree_q538_1_ConvertBST {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        travesal(root);
        return root;
    }

    private void travesal(TreeNode root) {
        if (root == null) {
            return ;
        }
        travesal(root.right);
        sum+=root.val;
        root.val = sum;
        travesal(root.left);
    }


//    private int sum = 0;
//
//    public TreeNode convertBST(TreeNode root) {
//        convertToBST(root);
//        return root;
//    }
//
//    private void convertToBST(TreeNode root) {
//        if (root == null) {
//            return ;
//        }
//        convertToBST(root.right);
//        sum += root.val;
//        root.val = sum;
//        convertToBST(root.left);
//    }

}
