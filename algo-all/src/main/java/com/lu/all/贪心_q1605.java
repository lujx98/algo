package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-03-14
 */
public class 贪心_q1605 {

    @Test
    public void test(){
        System.out.println(Arrays.toString(restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8})));
    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];

        int[] colRemain = Arrays.copyOf(colSum, colSum.length);
        for (int i = 0; i < rowSum.length; i++) {
            int rowRemain = rowSum[i];
            for (int j = 0; j < colSum.length; j++) {
                int de = Math.min(colRemain[j],rowRemain);
                colRemain[j] -= de;
                rowRemain -= de;
                res[i][j] = de;
            }
        }

        return res;
    }

}
