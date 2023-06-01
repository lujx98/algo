package com.lu.all;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2023-05-22
 */
public class rev_q1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        dfs(root, limit);
        return root;
    }

    private boolean dfs(TreeNode root, int limit) {
        boolean left = root.left != null && dfs(root.left, limit - root.val);
        boolean right = root.right != null && dfs(root.right, limit - root.val);
        if (left) {
            root.left = null;
        }
        if (right) {
            root.right = null;
        }
        return left && right;
    }

}
