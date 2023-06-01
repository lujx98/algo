package com.lu.all;

import org.junit.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * @author sheldon
 * @date 2023-05-31
 */
public class rev_q1130 {

    @Test
    public void test() {
        System.out.println(mctFromLeafValues(new int[]{6, 2, 4}));
    }

    private int[] arr;
    private int[][] maxs;
    private int[][] memo;

    public int mctFromLeafValues(int[] arr) {
        this.arr = arr;
        this.maxs = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            maxs[i][i] = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                maxs[i][j] = Math.max(maxs[i][j - 1], arr[j]);
            }
        }
        return dfs(0, arr.length - 1);
    }

    private int dfs(int start, int end) {
        if (end == start) {
            return 0;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            res = Math.min(res, dfs(start, i) + dfs(i + 1, end) + maxs[start][i] * maxs[i + 1][end]);
        }
        return memo[start][end] = res;
    }

}
