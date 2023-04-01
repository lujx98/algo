package com.lu.dmsxl.tree;



import com.lu.structure.TreeNode;


/**
 * @author sheldon
 * @date 2022-04-06
 */
public class Tree_q226_2_InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
