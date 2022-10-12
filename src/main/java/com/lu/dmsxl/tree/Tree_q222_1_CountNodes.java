package com.lu.dmsxl.tree;

import com.lu.structure.TreeNode;

import java.util.LinkedList;

/**
 * @author sheldon
 * @date 2022-04-19
 */
public class Tree_q222_1_CountNodes {

    public int countNodes1(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right){
            return countNodes1(root.right) + (1 << left);
        }else {
            return countNodes1(root.left) + (1 << right);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
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
