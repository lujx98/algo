package com.lu.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class q104 {
    public class TreeNode{
        TreeNode right;
        TreeNode left;
        Integer val;
    }

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root==null) {
            return depth;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            depth+=1;
        }
        return depth;
    }
}
