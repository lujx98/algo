package com.lu.daily;

import com.lu.structure.TreeNode;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class 树_q111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return extracted(root);
    }

    private int extracted(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int right = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);
        return Math.min(left, right) + 1;
    }

//    public int minDepth1(TreeNode root){
//        if (root == null) {
//            return 0;
//        }
//
//        int rightDepth = minDepth1(root.right);
//        int leftDepth = minDepth1(root.left);
//
//        if (root.right == null) {
//            return rightDepth + 1;
//        }
//
//        if (root.left == null) {
//            return leftDepth + 1;
//        }
//        return Math.min(rightDepth, leftDepth) + 1;
//    }
//
//    //todolu:
//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int depth = 0;
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            TreeNode cur = null;
//            ArrayList<TreeNode> objects = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                cur = queue.poll();
//                //如果当前节点的左右孩子都为空，直接返回最小深度
//                objects.add(cur);
//                if (cur.left != null) queue.offer(cur.left);
//                if (cur.right != null) queue.offer(cur.right);
//            }
//            if (!objects.contains(null)){
//                depth++;
//            }
//        }
//        return depth;
//    }
}
