package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-11-28
 */
public class rev_q813 {

    @Test
    public void test() {
        System.out.println(largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4));
    }

    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[k + 1][nums.length + 1];

        //初始化 前缀和数组
        double[] sum = new double[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        //初始化：dp[1][j]
        for (int i = 1; i <= nums.length; i++) {
            dp[1][i] = sum[i] / i;
        }

        //dp[i][j] 表示 数组0到j 分i组  最大是多少
        //i = 1   dp[i][j] 0到j的平均值
        //i != 1  dp[i][j] 表示0到j 分 i组的最大平均值
        // dp[i][j] = Math.max( dp[x][j-1]+sum(i-x)/(i-x) , dp[i][j])
        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= nums.length; j++) {
                for (int x = 1; x < j; x++) {
                    dp[i][j] = Math.max(dp[i - 1][x] + (sum[j] - sum[x]) / (j - x), dp[i][j]);
                }
            }
        }
        return dp[k][nums.length];
    }


}
