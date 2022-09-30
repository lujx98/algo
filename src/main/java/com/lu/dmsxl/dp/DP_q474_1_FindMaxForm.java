package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-08-25
 */
public class DP_q474_1_FindMaxForm {

    @Test
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] ints = new int[m+1][n+1];
        for (String str : strs) {
            int oneNumber = 0,zeroNumber = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') {
                    oneNumber++;
                }else {
                    zeroNumber++;
                }
            }
            for (int i = m; i >= zeroNumber; i--) {
                for (int j = n; j >= oneNumber; j--) {
                    ints[i][j] = Math.max(ints[i][j],ints[i-zeroNumber][j-oneNumber]+1);
                }
            }
        }
        return ints[m][n];
    }

}
