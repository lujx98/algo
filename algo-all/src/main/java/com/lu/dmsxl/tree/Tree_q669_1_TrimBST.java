package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-05-15
 */
public class Tree_q669_1_TrimBST {

    @Test
    public void test(){
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            root.right = null;
            root = trimBST(root.left,low,high);
        } else if (root.val < low) {
            root.left = null;
            root = trimBST(root.right,low,high);
        }

        if (root != null) root.left = trimBST(root.left, low, high);
        if (root != null) root.right = trimBST(root.right, low, high);
        return root;
    }

//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        //todo:没做出来
//        if (root == null) {
//            return null;
//        }
//        if (root.val > high) {
//            return trimBST(root.left,low,high);
//        }
//        if (root.val < low) {
//            return trimBST(root.right,low,high);
//        }
//        root.right = trimBST(root.right,low,high);
//        root.left = trimBST(root.left,low,high);
//        return root;
//    }

}
