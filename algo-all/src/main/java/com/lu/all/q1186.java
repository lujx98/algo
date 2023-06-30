package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-27
 */
public class q1186 {

    @Test
    public void test() {
        System.out.println(maximumSum(new int[]{1, -2, -2, 3}));
    }

    private int[] arr;
    private int[][] memo;

    public int maximumSum(int[] arr) {
        this.arr = arr;
        this.memo = new int[arr.length][2];
        int res = Integer.MIN_VALUE;
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(Math.max(dfs(0, 1), res), dfs(0, 0));
        }
        return res;
    }

    private int dfs(int i, int j) {
        if (i > arr.length - 1) {
            return Integer.MIN_VALUE;
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        if (j == 0) {
            return 0;
        } else {
            return memo[i][j] = Math.max(dfs(i + 1, 1) + arr[i], dfs(i + 1, 0));
        }
    }

}
