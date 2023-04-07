package com.lu.all;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-10-12
 */
public class 树_q110_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = check(root.left);
        if (left == -1) {
            return -1;
        }
        int right = check(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }


}
