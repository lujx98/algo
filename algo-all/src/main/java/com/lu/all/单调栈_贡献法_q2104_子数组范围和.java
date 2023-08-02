package com.lu.all;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sheldon
 * @date 2023-08-01
 */
public class 单调栈_贡献法_q2104_子数组范围和 {

    @Test
    public void test(){
        System.out.println(subArrayRanges(new int[]{1, 3, 3}));
    }

    public long subArrayRanges(int[] nums) {
        int length = nums.length;
        int[] leftMaxCon = new int[length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                leftMaxCon[i] = -1;
            } else {
                leftMaxCon[i] = deque.peek();
            }
            deque.push(i);
        }
        deque.clear();
        int[] rightMaxCon = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peek()] <= nums[i]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                rightMaxCon[i] = length;
            } else {
                rightMaxCon[i] = deque.peek();
            }
            deque.push(i);
        }
        long res = 0;
        for (int i = 0; i < leftMaxCon.length; i++) {
            res += (rightMaxCon[i] - i) * (long) (i - leftMaxCon[i]) * nums[i];
        }

        int[] leftMinCon = new int[length];
        deque.clear();
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] > nums[i]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                leftMinCon[i] = -1;
            } else {
                leftMinCon[i] = deque.peek();
            }
            deque.push(i);
        }
        deque.clear();
        int[] rightMinCon = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peek()] >= nums[i]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                rightMinCon[i] = length;
            } else {
                rightMinCon[i] = deque.peek();
            }
            deque.push(i);
        }
        for (int i = 0; i < leftMaxCon.length; i++) {
            res -= (rightMinCon[i] - i) * (long) (i - leftMinCon[i]) * nums[i];
        }
        return res;
    }

    public long subArrayRanges1(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i], min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += (max - min);
            }
        }
        return res;
    }

}
