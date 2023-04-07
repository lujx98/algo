package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-05-27
 */
public class 动态规划_q70_爬楼梯 {

    @Test
    public void test() {
        System.out.println(climbStairs1(4));
    }

    private int[] memo;

    public int climbStairs1(int n) {
        this.memo = new int[n+1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = (dfs(n - 1) + dfs(n - 2));
    }

    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

//    public int climbStairsTotal(int n){
//        if (n <= 1) return n; // 因为下面直接对dp[2]操作了，防止空指针
//        //todolu: 初始化n+1；
//        int[] ints = new int[n + 1];
//        ints[1] = 1;
//        ints[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            ints[i] = ints[i - 1] + ints[i - 2];
//        }
//        return ints[n];
//    }
//
//    public int climbStairs(int n) {
//        if (n <= 1) return n; // 因为下面直接对dp[2]操作了，防止空指针
//        //todolu: 初始化n+1；
//        int[] ints = new int[n + 1];
//        ints[1] = 1;
//        ints[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            ints[i] = ints[i - 1] + ints[i - 2];
//        }
//        return ints[n];
//    }
//
//    /**
//     * <a href="https://www.programmercarl.com/0070.%E7%88%AC%E6%A5%BC%E6%A2%AF%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85%E7%89%88%E6%9C%AC.html#_70-%E7%88%AC%E6%A5%BC%E6%A2%AF">...</a>
//     * @param n
//     * @return
//     */
//    public int climbStairs1(int n) {
//        if (n <= 1) return n; // 因为下面直接对dp[2]操作了，防止空指针
//        int[] ints = new int[n + 1];
//
//        return ints[n];
//    }

}
