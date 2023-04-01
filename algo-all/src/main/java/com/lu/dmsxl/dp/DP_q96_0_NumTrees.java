package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-05-31
 */
public class DP_q96_0_NumTrees {

    public int numTrees(int n) {
        int[] ints = new int[n+1];
        ints[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ints[i] += ints[j - 1] * ints[i-j];
            }
        }
        return ints[n];
    }

}
