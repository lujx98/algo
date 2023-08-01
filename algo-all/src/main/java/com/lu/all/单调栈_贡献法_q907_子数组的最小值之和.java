package com.lu.all;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author sheldon
 * @date 2023-07-31
 */
public class 单调栈_贡献法_q907_子数组的最小值之和 {
    
    public int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        Deque<Integer> leftQ = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!leftQ.isEmpty() && arr[leftQ.peek()] > arr[i]) {
                leftQ.pop();
            }
            if (leftQ.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = leftQ.peek();
            }
            leftQ.push(i);
        }

        int[] right = new int[arr.length];
        Deque<Integer> rightQ = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!rightQ.isEmpty() && arr[rightQ.peek()] >= arr[i]) {
                rightQ.pop();
            }
            if (rightQ.isEmpty()) {
                right[i] = arr.length;
            } else {
                right[i] = rightQ.peek();
            }
            rightQ.push(i);
        }

        int res = 0;
        for (int i = 0; i < left.length; i++) {
            res = (int) ((res + arr[i] * (long) (i - left[i]) * (long) (right[i] - i)) % (int) (1e9 + 7));
        }
        return res;
    }

}
