package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class 动态规划_记忆化搜索_q714_买卖股票的最佳时机含手续费 {

    private int fee;
    private int[] prices;
    private int[][] memo;

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
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
            res = Math.max(res, dfs(days + 1, 1) - prices[days] - this.fee);
        }
        return memo[days][status] = res;
    }

}
