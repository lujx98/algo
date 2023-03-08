package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-08
 */
public class qoffer47_动态规划 {

    @Test
    public void  test(){

    }

    public int maxValue(int[][] grid) {
        int y = grid.length, x = grid[0].length;
        int[] dp = new int[x];
        for (int i = 0; i < y; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < x; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[x - 1];
    }

}
