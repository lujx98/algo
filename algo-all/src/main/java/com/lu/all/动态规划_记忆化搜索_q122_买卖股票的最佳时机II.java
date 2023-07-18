package com.lu.all;

import org.junit.Test;
import sun.text.resources.th.FormatData_th;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class 动态规划_记忆化搜索_q122_买卖股票的最佳时机II {

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    private int[] prices;
    private int[][] memo;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.memo = new int[prices.length][2];
        for (int[] ints : this.memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, 0);
    }

    private int dfs(int days, int status) {
        if (days >= prices.length) {
            return 0;
        }
        if (memo[days][status] != -1) {
            return memo[days][status];
        }
        int res = dfs(days + 1, status);
        if (status == 1) {
            res = Math.max(res, dfs(days + 1, 0) + prices[days]);
        } else {
            res = Math.max(res, dfs(days + 1, 1) - prices[days]);
        }
        return memo[days][status] = res;
    }

//    public int maxProfit2(int[] prices) {
//        int[][] dp = new int[prices.length][2];
//        //dp[i][1] = max(dp[i-1][1], dp[i-1][0] -prices[i])
//        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] +prices[i])
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] -prices[i]);
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] +prices[i]);
//        }
//        return dp[prices.length-1][0];
//    }
//
//    public int maxProfit1(int[] prices) {
//        //dp[n][1] = Math.max(dp[n-1][1],-prices[n])
//        //dp[n][0] = Math.max(dp[n-1][0],dp[n][1]+prices[n])
//        int n = prices.length;
//        int[][] dp = new int[n][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        for (int i = 1; i < n; i++) {
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i][1] + prices[i]);
//        }
//        return dp[n - 1][0];
//    }
//
//    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length + 1][2];
//        dp[0][0] = 0;
//        dp[0][1] = 0;
//        dp[1][0] = 0;
//        dp[1][1] = -prices[0];
//
//        for (int i = 2; i <= prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
//        }
//        return dp[prices.length][0];
//    }

}
