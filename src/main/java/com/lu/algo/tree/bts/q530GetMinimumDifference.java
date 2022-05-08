package com.lu.algo.tree.bts;

/**
 * @author sheldon
 * @date 2022-05-08
 */
public class q530GetMinimumDifference {

    private class TreeNode {
        public TreeNode right;
        public TreeNode left;
        public int val;
    }

    private int min = Integer.MAX_VALUE;
    private TreeNode previousNode;

    public int getMinimumDifference(TreeNode root) {
        travesalTree(root);
        return min;
    }

    private void travesalTree(TreeNode root) {
        //todo ： 难以理解
        if (root == null) {
            return ;
        }
        travesalTree(root.left);
        if (previousNode != null) {
            int abs = Math.abs(root.val - previousNode.val);
            if (abs < min) {
                min = abs;
            }
        }
        previousNode = root;
        travesalTree(root.right);
    }

//    private void travesalTree(TreeNode root) {
//        if (root.left != null) {
//            previousNode = root;
//            travesalTree(root.left);
//        }
//        if (previousNode != root) {
//            int abs = Math.abs(root.val - previousNode.val);
//            if (abs < min) {
//                min = abs;
//            }
//        }
//        if (root.right != null) {
//            previousNode = root;
//            travesalTree(root.right);
//        }
//    }

}
