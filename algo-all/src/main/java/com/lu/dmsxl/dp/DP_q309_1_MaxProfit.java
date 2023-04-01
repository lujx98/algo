package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class DP_q309_1_MaxProfit {

    /**
     * 状态0 持有股票
     * 状态1 未持有股票且可买
     * 状态2 未持有股票 刚卖
     * 状态3 未持有股票 买后第二天
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length + 1][4];
        dp[1][0] = -prices[0];
        for (int i = 2; i <= length; i++) {
            //why  Math.max(dp[i - 1][1], dp[i - 1][3])
            //答：当前买入的情况有又可能是昨天是冻结期最后一天，今天刚好能买，也有可能是昨天就是已经过了冻结期了（昨天可以买但是没有买）
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + prices[i - 1]);
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[length][1], Math.max(dp[length][2], dp[length][3]));
    }

}
