package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-05-26
 */
public class DP_q509_2_Fib {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    public int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        int[] ints = new int[n];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

}
