package com.lu.all;

import com.lu.structure.ListNode;
import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2023-08-14
 */
public class 递归_q617_合并二叉树 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return null;
        }
        TreeNode node = new TreeNode();
        int val = 0;
        if (r1 != null) {
            val += r1.val;
        }
        if (r2 != null) {
            val += r2.val;
        }
        node.val = val;
        node.left = dfs(r1 == null ? null : r1.left, r2 == null ? null : r2.left);
        node.right = dfs(r1 == null ? null : r1.right, r2 == null ? null : r2.right);
        return node;
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;


        root1.left = mergeTrees1(root1.left,root2.left);
        root1.right = mergeTrees1(root1.right,root2.right);
        return root1;
    }

}
