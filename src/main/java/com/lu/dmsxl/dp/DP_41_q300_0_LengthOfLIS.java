package com.lu.dmsxl.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class DP_41_q300_0_LengthOfLIS {

    @Test
    public void test() {
        System.out.println(lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        //dp[i] 表示第i位为止最大的子序列
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
