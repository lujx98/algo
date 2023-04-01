package com.lu.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class q515 {
    public class TreeNode{
        public Integer val;
        public TreeNode right;
        public TreeNode left;
    }

    public List<Integer> largestValues(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left!=null) {
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            result.add(Collections.max(level));
        }
        return result;
    }
}
