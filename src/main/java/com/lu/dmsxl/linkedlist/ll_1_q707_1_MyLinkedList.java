package com.lu.dmsxl.linkedlist;

import lombok.Data;
import lombok.val;

/**
 * @author sheldon
 * @date 2022-12-09
 */
public class ll_1_q707_1_MyLinkedList {

    static class MyLinkedList {

        private int length = 0;
        private Node head;
        private Node tail;

        public MyLinkedList() {
            head = new Node();
            tail = new Node();
            //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
            head.next=tail;
            tail.prev=head;
        }

        public int get(int index) {
            Node res = findNode(index);
            return res.val;
        }

        private Node findNode(int index) {
            Node res;
            if (index > length / 2) {
                int temp = length - 1;
                res = tail.prev;
                while (temp != index) {
                    res = res.prev;
                    temp--;
                }
            } else {
                int temp = 0;
                res = head.next;
                while (temp != index) {
                    res = res.next;
                    temp++;
                }
            }
            return res;
        }

        public void addAtHead(int val) {
            Node node = new Node();
            node.val = val;
            Node h = head.next;
            head.next = h.prev = node;
            length++;
        }

        public void addAtTail(int val) {
            Node node = new Node();
            node.val = val;
            Node p = tail.prev;
            tail.prev = p.next = node;
            length++;
        }

        public void addAtIndex(int index, int val) {
            Node node1 = new Node();
            node1.val = val;
            Node node = findNode(index);
            Node prev = node.prev;
            prev.next = node1;
            node1.next = node;
            node.prev = node1;
            length++;
        }

        public void deleteAtIndex(int index) {
            Node res = findNode(index);
            res.next.prev = res.prev;
            res.prev.next = res.next;
            length--;
        }

        @Data
        private static class Node {
            private Node next;
            private Node prev;
            private int val;
        }

    }

}
