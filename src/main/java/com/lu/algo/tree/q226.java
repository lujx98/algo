package com.lu.algo.tree;


import com.sun.istack.internal.Nullable;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * @author sheldon
 * @date 2022-04-06
 */
public class q226 {

    public class TreeNode{
        public Integer val;
        public TreeNode right;
        public TreeNode left;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode temp = null;
        temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    @Nullable
    public TreeNode invertTreeBFS(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return root;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode temp = poll.right;
            poll.right = poll.left;
            poll.left = temp;
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return root;
    }

}
