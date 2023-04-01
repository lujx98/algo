package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-05-31
 */
public class DP_q343_1_IntegerBreak {

    @Test
    public void test() {
        System.out.println(integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 3; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), (i - j) * dp[j]));
            }
        }
        return dp[n];
    }

//    public int integerBreak2(int n) {
//        int[] ints = new int[n + 1];
//        ints[0] = 0;
//        ints[1] = 0;
//        ints[2] = 1;
//        for (int i = 0; i <= n; i++) {
//            for (int j = 2; j < i; j++) {
//                ints[i] = Math.max(ints[i], ints[i - j] * ints[j]);
//            }
//        }
//
//        return 0;
//    }
//
//    public int integerBreak1(int n) {
//        int[] ints = new int[n + 1];
//        ints[2] = 1;
//        for (int i = 0; i <= n; i++) {
//            for (int j = 1; j <= i - j; j++) {
//                ints[i] = Math.max(ints[i], Math.max(j * (i - j), j * ints[i - j]));
//            }
//        }
//        return ints[n];
//    }
//
//    public int integerBreak(int n) {
//        if (n <= 2) {
//            return n;
//        }
//        int[] ints = new int[n];
//        ints[0] = 0;
//        ints[1] = 1;
//        for (int i = 3; i < n; i++) {
//            ints[i] = Math.max(i * (n - i), ints[i] * (n - i));
//        }
//        return ints[n - 1];
//    }

}
