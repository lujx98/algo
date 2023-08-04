package com.lu.all;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-08-03
 */
public class rev_单调栈_q503_下一个更大元素II {

    @Test
    public void test() {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,1})));
    }

    public int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] toRight = new int[nums.length];
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i % nums.length]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                toRight[i % nums.length] = -1;
            } else {
                toRight[i % nums.length] = nums[deque.peek()];
            }
            deque.push(i % nums.length);
        }
        return toRight;
    }

}
