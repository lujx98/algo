package com.lu.dmsxl.dp;


import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-03-19
 */
public class DP_32_q121_1_MaxProfit {
    //max(f(t-1),)
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    public void test() {
        System.out.println(maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit3(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //dp[i][1]表示在第i天时持有股票的收益  dp[i][0]表示不持有股票的收益
        //dp[i][1] = max(dp[i-1][1], -prices[i])
        //dp[i][0] = max(dp[i-1][1]+price[i], dp[i-1][0])
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices) {
        //dp[n][1] = Math.max(dp[n-1][1],-prices[n])
        //dp[n][0] = Math.max(dp[n-1][0],dp[n][1]+prices[n])
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i][1] + prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 动态规划:
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = -prices[0];

        for (int i = 2; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
        }

        return dp[prices.length][0];
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    public static int bestAns(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
