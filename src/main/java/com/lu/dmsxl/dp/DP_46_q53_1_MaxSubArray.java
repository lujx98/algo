package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-11-26
 */
public class DP_46_q53_1_MaxSubArray {

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        //dp[n]表示
        int[] dp = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if ((dp[i] = Math.max(nums[i-1], dp[i - 1] + nums[i-1])) > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
