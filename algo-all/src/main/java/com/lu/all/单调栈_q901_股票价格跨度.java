package com.lu.all;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author sheldon
 * @date 2023-10-07
 */
public class 单调栈_q901_股票价格跨度 {

    @Test
    public void test() {

    }

    static class StockSpanner {

        private LinkedList<int[]> stack = new LinkedList<>();
        private int day = 0;

        public StockSpanner() {

        }

        public int next(int price) {
            while (!stack.isEmpty() && stack.peek()[1] < price) {
                stack.pop();
            }
            day++;
            if (stack.isEmpty()) {
                stack.push(new int[]{day, price});
                return day;
            } else {
                int i = day - stack.peek()[0];
                stack.push(new int[]{day, price});
                return i;
            }
        }

    }

}
