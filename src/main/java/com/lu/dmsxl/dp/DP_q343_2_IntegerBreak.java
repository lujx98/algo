package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-05-31
 */
public class DP_q343_2_IntegerBreak {

    public int integerBreak1(int n) {
        int[] ints = new int[n + 1];
        ints[2] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                ints[i] = Math.max(ints[i], Math.max(j * (i - j), j * ints[i - j]));
            }
        }
        return ints[n];
    }

    public int integerBreak(int n) {
        if (n <= 2) {
            return n;
        }
        int[] ints = new int[n];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 3; i < n; i++) {
            ints[i] = Math.max(i * (n - i), ints[i] * (n - i));
        }
        return ints[n - 1];
    }

}
