package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-11
 */
public class 思路_q6449_收集巧克力 {

    @Test
    public void test() {
        System.out.println(minCost(new int[]{20, 1, 15}, 5));
    }

    public long minCost(int[] nums, int x) {
        long res = 0L;
        for (int num : nums) {
            res += num;
        }
        int[] min = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            long curMovingCount = 0;
            for (int j = 0; j < nums.length; j++) {
                min[j] = Math.min(min[j], nums[(i + j) % nums.length]);
                curMovingCount += min[j];
            }
            res = Math.min(res, curMovingCount + ((long) x * i));
        }
        return res;
    }

}
