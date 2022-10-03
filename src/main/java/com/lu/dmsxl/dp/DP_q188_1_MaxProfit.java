package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class DP_q188_1_MaxProfit {

    @Test
    public void test(){
        System.out.println(maxProfit(2,new int[]{3,3,5,0,0,3,1,4}));
    }

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length + 1][k * 2];
        //数组初始化 奇数情况初始化为-prices
        for (int i = 0; i < dp[1].length; i++) {
            if (i % 2 == 0) {
                dp[1][i] = -prices[0];
            }
        }
        //遍历天数
        for (int i = 2; i <= prices.length; i++) {
            //遍历卖出情况
            for (int j = 0; j < 2 * k; j = j + 2) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], -prices[i - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + 1] - prices[i - 1]);
                }
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i - 1]);
            }

        }
        return dp[prices.length][2 * k - 1];
    }

}
