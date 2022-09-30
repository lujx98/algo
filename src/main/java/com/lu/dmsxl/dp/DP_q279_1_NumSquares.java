package com.lu.dmsxl.dp;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;

/**
 * @author sheldon
 * @date 2022-09-30
 */
public class DP_q279_1_NumSquares {

    @Test
    public void test() {
        System.out.println(numSquares(12));
    }

    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }

}
