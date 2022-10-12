package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-10-12
 */
public class Tree_q110_1_IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = check(root.right);
        if (right == -1) {
            return -1;
        }
        int left = check(root.left);
        if (left == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }


}
