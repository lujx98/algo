package com.lu.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class q113PathSum {

    public LinkedList path;
    public List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.path = new LinkedList();
        travesal(root, targetSum);
        return result;
    }

    public void travesal(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offer(root.val);
        targetSum -= root.val;
        if (root.right == null && root.left == null) {
            if (targetSum == 0) {
                result.add(new LinkedList<>(path));
            }
        }
        if (root.left != null) {
            travesal(root.left, targetSum);
        }
        if (root.right != null) {
            travesal(root.right, targetSum);
        }
        path.removeLast();
    }

    public class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

}
