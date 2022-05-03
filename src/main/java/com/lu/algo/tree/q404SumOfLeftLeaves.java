package com.lu.algo.tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author sheldon
 * @date 2022-05-03
 */
public class q404SumOfLeftLeaves {

    public class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return travesal(root);
    }

    public int travesal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int shardingResult = 0;

        if (root.left != null && root.left.left== null && root.left.right == null) {
            shardingResult += root.left.val;
        }

        shardingResult += travesal(root.left);
        shardingResult += travesal(root.right);

        return shardingResult;
    }

    public int sumOfLeftLeaves1(TreeNode root){



        return 0;
    }

}
