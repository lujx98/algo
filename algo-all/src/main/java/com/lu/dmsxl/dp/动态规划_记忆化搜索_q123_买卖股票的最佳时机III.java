package com.lu.dmsxl.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class 动态规划_记忆化搜索_q123_买卖股票的最佳时机III {

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    private int[] prices;
    private int[][][] memo;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.memo = new int[prices.length][2][2];
        for (int[][] ints : this.memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(0, 0, 0);
    }

    private int dfs(int days, int status, int times) {
        if (days >= prices.length) {
            return 0;
        }
        if (times >= 2) {
            return 0;
        }
        if (memo[days][status][times] != -1) {
            return memo[days][status][times];
        }
        int res = dfs(days + 1, status, times);
        if (status == 1) {
            res = Math.max(res, dfs(days + 1, 0, times + 1) + prices[days]);
        } else {
            res = Math.max(res, dfs(days + 1, 1, times) - prices[days]);
        }
        return memo[days][status][times] = res;
    }

//    public int maxProfit1(int[] prices) {
//        int[][] dp = new int[prices.length][4];
//        dp[0][0] = -prices[0];
//        dp[0][2] = -prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
//            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
//        }
//
//        return dp[prices.length - 1][3];
//    }
//
//
//    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length + 1][4];
//        dp[1][0] = -prices[0];
//        dp[1][1] = 0;
//        dp[1][2] = -prices[0];
//        dp[1][3] = 0;
//        for (int i = 2; i <= prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], -prices[i - 1]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i - 1]);
//            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i - 1]);
//        }
//        return dp[prices.length][3];
//    }

}
