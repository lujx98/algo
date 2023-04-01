package com.lu.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class q637 {
    public class TreeNode{
        public TreeNode right;
        public TreeNode left;
        public Integer val;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();
        LinkedList<TreeNode> nodeLinkedList = new LinkedList<>();
        nodeLinkedList.offer(root);
        while (!nodeLinkedList.isEmpty()){
            int size = nodeLinkedList.size();
            Double all = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodeLinkedList.poll();
                all+=poll.val;
                if (poll.left!=null) {
                    nodeLinkedList.offer(poll.left);
                }
                if (poll.right!=null){
                    nodeLinkedList.offer(poll.right);
                }
            }
            result.add(all/size);
        }
        return result;
    }
}
