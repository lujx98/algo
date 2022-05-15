package com.lu.algo.tree.bts;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author sheldon
 * @date 2022-05-15
 */
public class q450DeleteNode {

    public class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null && root.right != null) {
                return root.right;
            }
            if (root.left != null && root.right == null) {
                return root.left;
            }
            if (root.left != null && root.right != null) {
                TreeNode temp = root.left;
                TreeNode temp1 = root.right;
                while (temp1.left != null) {
                    temp1 = temp1.left;
                }
                temp1.left = temp;
                return root.right;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

}
