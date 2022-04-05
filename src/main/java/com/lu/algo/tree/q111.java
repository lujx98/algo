package com.lu.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class q111 {
    public class TreeNode {
        public Integer val;
        public TreeNode right;
        public TreeNode left;
    }

    //todolu:
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode cur = null;
            ArrayList<TreeNode> objects = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                //如果当前节点的左右孩子都为空，直接返回最小深度
                objects.add(cur);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (!objects.contains(null)){
                depth++;
            }
        }
        return depth;
    }
}
