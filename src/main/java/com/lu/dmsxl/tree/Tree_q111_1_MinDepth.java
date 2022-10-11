package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class Tree_q111_1_MinDepth {

    public int minDepth1(TreeNode root){
        if (root == null) {
            return 0;
        }

        int rightDepth = minDepth1(root.right);
        int leftDepth = minDepth1(root.left);

        if (root.right == null) {
            return rightDepth + 1;
        }

        if (root.left == null) {
            return leftDepth + 1;
        }
        return Math.min(rightDepth, leftDepth) + 1;
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
