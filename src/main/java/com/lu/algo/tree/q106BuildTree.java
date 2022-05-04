package com.lu.algo.tree;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class q106BuildTree {

    public class TreeNode{
        public TreeNode right;
        public TreeNode left;
        public Integer val;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode treeNode = new TreeNode();
        if (inorder.length == 0) {
            return treeNode;
        }
        int i = postorder[postorder.length - 1];
        return treeNode;
    }

    public TreeNode buildTree(int[] inorder,int inleft,int inright,
                              int[] postorder,int postleft,int postright){
        //todo;
        return new TreeNode();
    }

}
