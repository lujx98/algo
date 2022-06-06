package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-05-31
 */
public class q343IntegerBreak {

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
