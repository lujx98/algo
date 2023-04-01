package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class DP_35_q123_1_MaxProfit {

    @Test
    public void test() {
        System.out.println(maxProfit1(new int[]{1,2,3,4,5}));
    }

    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }

        return dp[prices.length - 1][3];
    }


    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][4];
        dp[1][0] = -prices[0];
        dp[1][1] = 0;
        dp[1][2] = -prices[0];
        dp[1][3] = 0;
        for (int i = 2; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i - 1]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i - 1]);
        }
        return dp[prices.length][3];
    }

}
