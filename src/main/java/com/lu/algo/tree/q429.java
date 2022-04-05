package com.lu.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class q429 {
    public class Node{
        public Integer val;
        public List<Node> children;
    }

    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                levelList.add(poll.val);
                queue.addAll(poll.children);
            }
            result.add(levelList);
        }
        return result;
    }
}
