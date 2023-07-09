package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-07-08
 */
public class 模拟_q6913_最长交替子序列 {

    @Test
    public void test() {
        System.out.println(alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
    }

    public int alternatingSubarray(int[] nums) {
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                int index = i;
                int count = 1;
                int temp = 1;
                while (index < nums.length && nums[index] - nums[index - 1] == temp) {
                    count++;
                    index++;
                    temp *= -1;
                }
                res = Math.max(res, count);
            }
        }

        return res == 1 ? -1 : res;
    }

}
