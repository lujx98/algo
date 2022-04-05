package com.lu.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class q199 {
    public class TreeNode{
        public Integer val;
        public TreeNode right;
        public TreeNode left;
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode last = queue.getLast();
            result.add(last.val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null)queue.offer(poll.left);
                if (poll.right!=null)queue.offer(poll.right);
            }
        }
        return result;
    }
}
