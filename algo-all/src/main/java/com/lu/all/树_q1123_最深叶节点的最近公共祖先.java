package com.lu.all;

import com.lu.structure.TreeNode;

import javax.swing.plaf.metal.MetalTheme;

/**
 * @author sheldon
 * @date 2023-09-08
 */
public class 树_q1123_最深叶节点的最近公共祖先 {

    private TreeNode res;
    private int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int dfs = dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        int leftMaxDepth = dfs(root.left, depth + 1);
        int rightMaxDepth = dfs(root.right, depth + 1);
        if (leftMaxDepth == rightMaxDepth && rightMaxDepth == maxDepth) {
            res = root;
        }
        return Math.max(leftMaxDepth, rightMaxDepth);
    }

}
