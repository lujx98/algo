package com.lu.dmsxl.linkedlist;

import lombok.Data;
import lombok.val;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-09
 */
public class ll_1_q707_1_MyLinkedList {

    @Test
    public void test() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3
    }

    static class MyLinkedList {

        private int length = 0;
        private Node head;
        private Node tail;

        public MyLinkedList() {
            head = new Node();
            tail = new Node();
            //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            Node res = findNode(index);
            return res.next.val;
        }

        private Node findNode(int index) {
            Node res;
            if (index > length / 2) {
                int temp = length;
                res = tail.prev;
                while (temp != index) {
                    res = res.prev;
                    temp--;
                }
            } else {
                int temp = 1;
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
            node.next = h;
            node.prev = head;
            length++;
        }

        public void addAtTail(int val) {
            Node node = new Node();
            node.val = val;
            node.next = tail;
            Node p = tail.prev;
            node.prev = p;
            tail.prev = p.next = node;
            length++;
        }

        public void addAtIndex(int index, int val) {
            Node insert = new Node();
            insert.val = val;
            Node node = findNode(index);
            Node next = node.next;
            next.prev = insert;
            node.next = insert;
            insert.prev = node;
            insert.next = next;
            length++;
        }

        public void deleteAtIndex(int index) {
            Node res = findNode(index);
            res = res.next;
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
