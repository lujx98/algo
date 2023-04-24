package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-07
 */
public class 动态规划_q剑指Offer10_爬楼梯 {

    @Test
    public void test(){
        System.out.println(numWays(44));
    }

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 2) {
            return n;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1L;
        dp[1] = 1L;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % (int) (1e9 + 7);
        }
        return (int)(dp[n]);
    }

}
