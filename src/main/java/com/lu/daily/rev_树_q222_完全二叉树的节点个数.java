package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-04-19
 */
public class rev_树_q222_完全二叉树的节点个数 {

    @Test
    public void test() {
//        System.out.println(JacksonUtil.toJson(countNodes(TreeUtils.makeTree("[1,2,3,4,5,6]"))));
    }

//    private int res = 0;
//
//    //没做出来
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = root.left == null ? 0 : getDepth(root.left);
//        int right = root.right == null ? 0 : getDepth(root.right);
//        if (left == 0 && right == 0) {
//            res++;
//            return 0;
//        }
//        if (left != right) {
//            res += Math.pow(2, right - 1);
//            countNodes(root.left);
//
//        } else {
//            res += Math.pow(2, left - 1);
//            countNodes(root.right);
//        }
//        return res;
//    }
//
//    private int getDepth(TreeNode root) {
//        if (root.left != null) {
//            return getDepth(root.left) + 1;
//        }
//        return 1;
//    }

//    public int countNodes1(TreeNode root){
//        if (root == null) {
//            return 0;
//        }
//        int left = getDepth(root.left);
//        int right = getDepth(root.right);
//        if (left == right){
//            return countNodes1(root.right) + (1 << left);
//        }else {
//            return countNodes1(root.left) + (1 << right);
//        }
//    }
//
//    private int getDepth(TreeNode root) {
//        int depth = 0;
//        while (root != null) {
//            root = root.left;
//            depth++;
//        }
//        return depth;
//    }
//
//    public int countNodes(TreeNode root) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        if (root==null){
//            return 0;
//        }
//        queue.offer(root);
//        int count = 0;
//        while (!queue.isEmpty()) {
//            TreeNode poll = queue.poll();
//            if (poll.left!=null) {
//                queue.offer(poll.left);
//            }
//            if (poll.right!=null) {
//                queue.offer(poll.right);
//            }
//            count+=1;
//        }
//        return count;
//    }

}
