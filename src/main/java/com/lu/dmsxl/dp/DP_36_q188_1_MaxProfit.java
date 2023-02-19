package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class DP_36_q188_1_MaxProfit {

    @Test
    public void test() {
        System.out.println(maxProfit1(2, new int[]{2, 4, 1}));
    }

    public int maxProfit2(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k];
        for (int i = 0; i < k; i++) {
            dp[0][2 * i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            for (int j = 2; j < 2 * k; j++) {
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[prices.length - 1][2 * k - 1];
    }

    public int maxProfit1(int k, int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2 * k];
        for (int i = 0; i < 2 * k; i++) {
            if (i % 2 == 1) dp[0][i] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < 2 * k; j++) {
                //dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                //dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], j == 0 ? 0 : dp[i - 1][j - 1] + prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
            }
        }
        return dp[length - 1][2 * k - 2];
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
