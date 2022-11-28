package com.lu.daily;

import com.google.common.eventbus.AllowConcurrentEvents;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-11-28
 */
public class q813_1 {

    @Test
    public void test(){
        System.out.println(largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
    }

    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[k + 1][nums.length + 1];

        int max = 0;
        //dp[i][j] 表示 数组0到j 分i组  最大是多少
        //i = 1   dp[i][j] 0到j的平均值
        //i != 1  dp[i][j] 表示0到j 分 i组的最大平均值
        // dp[i][j] = Math.max( dp[x][j-1]+sum(i-x)/(i-x) , dp[i][j])
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= nums.length; j++) {
                for (int x = 1; x <= j; x++) {
                    double sum1 = 0.0;
                    for (int a = j; a < x; a++) {
                        sum1 += nums[a];
                    }
                    dp[i][j] = Math.max(dp[i-1][x] + sum1 / (j - x), dp[i][j]);
                }
            }
        }
        return dp[k][nums.length];
    }


}
