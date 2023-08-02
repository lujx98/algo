package com.lu.all;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @author sheldon
 * @date 2023-08-02
 */
public class 单调栈_前缀和_q1856_子数组最小乘积的最大值 {

    @Test
    public void test() {
        System.out.println(maxSumMinProduct(new int[]{1, 2, 3, 2}));
    }

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] >= nums[i]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = deque.peek();
            }
            deque.push(i);
        }
        deque.clear();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peek()] > nums[i]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = deque.peek();
            }
            deque.push(i);
        }

        long res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long comp = ((nums[i] * (prefix[right[i]] - prefix[left[i] + 1])));
            res = Math.max(res, comp);
        }
        return (int) (res % (int) (1e9 + 7));
    }

}
