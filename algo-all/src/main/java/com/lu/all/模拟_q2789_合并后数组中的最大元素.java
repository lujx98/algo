package com.lu.all;

import org.junit.Test;

import java.util.Stack;

/**
 * @author sheldon
 * @date 2023-07-26
 */
public class 模拟_q2789_合并后数组中的最大元素 {

    @Test
    public void test() {
        System.out.println(maxArrayValue(new int[]{5, 3, 3}));
    }

    public long maxArrayValue(int[] nums) {
        Stack<Long> stack = new Stack<>();
        long res = 0;
        for (int i = nums.length - 1; i >= 0; ) {
            stack.push((long) nums[i]);
            i--;
            while (i >= 0 && nums[i] <= nums[i + 1]) {
                stack.push((long) nums[i--]);
            }
            Long pop = stack.pop();
            long cur = pop;
            while (!stack.isEmpty() && pop <= stack.peek()) {
                cur += stack.peek();
                pop = stack.pop();
            }
            stack.push(cur);
            res = Math.max(res, cur);
        }
        return res;
    }

}
