package com.lu.all;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @author sheldon
 * @date 2023-04-07
 */
public class 模拟_q剑指Offer09_用两个栈实现队列 {

    @Test
    public void test() {
        CQueue cQueue = new CQueue();
        cQueue.deleteHead();
        cQueue.appendTail(5);
        cQueue.appendTail(1);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    public static class CQueue {

        private ArrayDeque<Integer> delete = new ArrayDeque<>();
        private ArrayDeque<Integer> store = new ArrayDeque<>();
        private boolean deleteMode = false;

        public CQueue() {

        }

        public void appendTail(int value) {
            if (deleteMode) {
                toggle();
            }
            store.add(value);
        }

        public int deleteHead() {
            if (!deleteMode) {
                toggle();
            }
            if (delete.isEmpty()) {
                return -1;
            }
            return delete.pop();
        }

        private void toggle() {
            if (store.isEmpty()) {
                while (!delete.isEmpty()) {
                    store.push(delete.removeLast());
                }
                deleteMode = false;
            } else if (delete.isEmpty()){
                while (!store.isEmpty()) {
                    delete.push(store.removeLast());
                }
                deleteMode = true;
            }
        }

    }

}
