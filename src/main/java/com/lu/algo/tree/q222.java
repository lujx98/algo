package com.lu.algo.tree;

import java.util.LinkedList;

/**
 * @author sheldon
 * @date 2022-04-19
 */
public class q222 {


    public class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int val;
    }

    public int countNodes(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return 0;
        }
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left!=null) {
                queue.offer(poll.left);
            }
            if (poll.right!=null) {
                queue.offer(poll.right);
            }
            count+=1;
        }
        return count;
    }

}
