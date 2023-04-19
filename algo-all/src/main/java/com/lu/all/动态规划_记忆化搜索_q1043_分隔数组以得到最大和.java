package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-04-19
 */
public class 动态规划_记忆化搜索_q1043_分隔数组以得到最大和 {

    @Test
    public void test() {
        System.out.println(maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
    }

    private int k = 0;
    private int[][] memo;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        memo = new int[arr.length][arr.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        this.k = k;
        return dfs(arr, 0, arr.length - 1);
    }

    private int dfs(int[] arr, int start, int end) {
        if (memo[start][end] != -1) {
            return memo[start][end];
        }
        if (end - start < k) {
            return memo[start][end] = getMax(arr, start, end);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.max(res, dfs(arr, start, start + i) + dfs(arr, start + i + 1, end));
        }
        return memo[start][end] = res;
    }

    private int getMax(int[] arr, int start, int end) {
        int res = arr[start];
        for (int i = start; i <= end; i++) {
            res = Math.max(res, arr[i]);
        }
        return res * (end - start + 1);
    }

}
