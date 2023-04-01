package com.lu.daily;

import java.util.PriorityQueue;

/**
 * @author sheldon
 * @date 2023-01-18
 */
public class rev_q1825 {

    static class MKAverage {

        private int m;
        private int k;
        private PriorityQueue set = new PriorityQueue();
        private int len = 0;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
        }

        public void addElement(int num) {
            len++;
        }

        public int calculateMKAverage() {
            if (len < m) {
                return -1;
            }
            return 0;
        }
    }

}
