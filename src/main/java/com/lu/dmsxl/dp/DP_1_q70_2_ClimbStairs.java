package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-05-27
 */
public class DP_1_q70_2_ClimbStairs {

    public int climbStairsTotal(int n){
        if (n <= 1) return n; // 因为下面直接对dp[2]操作了，防止空指针
        //todolu: 初始化n+1；
        int[] ints = new int[n + 1];
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    public int climbStairs(int n) {
        if (n <= 1) return n; // 因为下面直接对dp[2]操作了，防止空指针
        //todolu: 初始化n+1；
        int[] ints = new int[n + 1];
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    /**
     * <a href="https://www.programmercarl.com/0070.%E7%88%AC%E6%A5%BC%E6%A2%AF%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85%E7%89%88%E6%9C%AC.html#_70-%E7%88%AC%E6%A5%BC%E6%A2%AF">...</a>
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 1) return n; // 因为下面直接对dp[2]操作了，防止空指针
        int[] ints = new int[n + 1];

        return ints[n];
    }

}
