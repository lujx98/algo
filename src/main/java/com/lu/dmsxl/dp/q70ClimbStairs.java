package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-05-27
 */
public class q70ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 1) return n; // 因为下面直接对dp[2]操作了，防止空指针
        int[] ints = new int[n + 1];
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

}
