package com.lu.algo.tree;

import java.util.LinkedList;

/**
 * @author sheldon
 * @date 2022-04-05
 */
public class q117 {
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

    /**
     * todolu:best answer
     * @param root
     * @return
     */
    public Node connectBest(Node root) {
        if(root==null) return root;
        if(root.left!=null && root.right!=null){
            root.left.next=root.right;
        }
        if(root.left!=null && root.right==null){
            root.left.next=getNext(root.next);
        }
        if(root.right!=null)
            root.right.next=getNext(root.next);
        connect(root.right);
        connect(root.left);
        return root;
    }
    
    public Node getNext(Node root){
        if(root==null) return null;
        if(root.left!=null) return root.left;
        if(root.right!=null) return root.right;
        if(root.next!=null) return getNext(root.next);
        return null;
    }
}
