package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-05-15
 */
public class Tree_q450_1_DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.right == null && root.left != null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.left == null && root.right == null) {
                return null;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) {
//            return root;
//        }
//        if (root.val == key) {
//            if (root.left == null && root.right == null) {
//                return null;
//            }
//            if (root.left == null && root.right != null) {
//                return root.right;
//            }
//            if (root.left != null && root.right == null) {
//                return root.left;
//            }
//            if (root.left != null && root.right != null) {
//                TreeNode temp = root.left;
//                TreeNode temp1 = root.right;
//                while (temp1.left != null) {
//                    temp1 = temp1.left;
//                }
//                temp1.left = temp;
//                return root.right;
//            }
//        } else if (root.val > key) {
//            root.left = deleteNode(root.left, key);
//        } else {
//            root.right = deleteNode(root.right, key);
//        }
//        return root;
//    }

}
