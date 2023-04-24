package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-07
 */
public class 动态规划_q剑指Offer10_斐波那契数列 {

    @Test
    public void test() {
        System.out.println(fib(3));
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])% (int)(1e9 + 7);
        }
        return dp[n] ;
    }

}
