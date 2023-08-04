package com.lu.all;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sheldon
 * @date 2023-08-04
 */
public class 单调栈_q84_柱状图中最大的矩形 {

    @Test
    public void test() {
        System.out.println(largestRectangleArea(new int[]{1,1}));
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] left = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] > heights[i]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = deque.peek();
            }
            deque.push(i);
        }
        int[] right = new int[heights.length];
        deque.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                right[i] = heights.length;
            } else {
                right[i] = deque.peek();
            }
            deque.push(i);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * ((right[i] - i - 1) + (i - left[i])));
        }
        return res;
    }

}
