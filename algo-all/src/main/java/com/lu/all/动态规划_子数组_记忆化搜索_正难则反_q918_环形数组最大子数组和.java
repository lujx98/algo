package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-20
 */
public class 动态规划_子数组_记忆化搜索_正难则反_q918_环形数组最大子数组和 {

    @Test
    public void test() {
        System.out.println(maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }

    private int[] nums;
    private int[] memoMax;
    private int[] memoMin;

    public int maxSubarraySumCircular(int[] nums) {
        this.nums = nums;
        int sum = Arrays.stream(nums).sum();
        int resMin = Integer.MAX_VALUE;
        int resMax = Integer.MIN_VALUE;
        this.memoMax = new int[nums.length];
        Arrays.fill(memoMax, -1);
        this.memoMin = new int[nums.length];
        Arrays.fill(memoMin, -1);
        for (int i = 0; i < nums.length; i++) {
            resMin = Math.min(resMin, dfsMin(i));
            resMax = Math.max(resMax, dfsMax(i));
        }
        if (resMax < 0) {
            return resMax;
        }
        return Math.max(resMax, sum - resMin);
    }

    private int dfsMin(int i) {
        if (i < 0) {
            return 0;
        }
        if (memoMin[i] != -1) {
            return memoMin[i];
        }
        return memoMin[i] = Math.min(nums[i], nums[i] + dfsMin(i - 1));
    }

    private int dfsMax(int i) {
        if (i < 0) {
            return 0;
        }
        if (memoMax[i] != -1) {
            return memoMax[i];
        }
        return memoMax[i] = Math.max(nums[i], nums[i] + dfsMax(i - 1));
    }

}
