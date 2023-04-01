package com.lu.algo.tree;

import java.util.LinkedList;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class q116 {
    public class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) {
            return root;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node temp = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }

                if (temp !=null) {
                    temp.next=poll;
                }
                temp  =  poll;
            }
        }
        return root;
    }

}
