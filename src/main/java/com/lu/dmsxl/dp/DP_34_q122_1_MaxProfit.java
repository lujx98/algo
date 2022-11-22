package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class DP_34_q122_1_MaxProfit {

    @Test
    public void test() {
        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit1(int[] prices) {
        //dp[n][1] = Math.max(dp[n-1][1],-prices[n])
        //dp[n][0] = Math.max(dp[n-1][0],dp[n][1]+prices[n])
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i][1] + prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = -prices[0];

        for (int i = 2; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[prices.length][0];
    }

}
