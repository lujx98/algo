package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-08-18
 */
public class 动态规划_打家劫舍_记忆化搜索_q1388_3n块披萨 {

    @Test
    public void test() {
        System.out.println(maxSizeSlices(new int[]{9, 5, 1, 7, 8, 4, 4, 5, 5, 8, 7, 7}));
    }

    private Integer[][][] memo;
    private int[] slices;

    public int maxSizeSlices(int[] slices) {
        this.slices = slices;
        this.memo = new Integer[slices.length][slices.length / 3 + 1][2];
        return Math.max(dfs(2, slices.length / 3 - 1, 1) + slices[0], dfs(1, slices.length / 3, 0));
    }

    private int dfs(int i, int remain, int has0) {
        if (i >= slices.length || remain == 0) {
            return 0;
        }
        if (i == slices.length - 1) {
            return has0 == 0 ? slices[i] : 0;
        }
        if (memo[i][remain][has0] != null) {
            return memo[i][remain][has0];
        }
        int dfs = dfs(i + 1, remain, has0);
        int dfs1 = dfs(i + 2, remain - 1, has0);
        return memo[i][remain][has0] = Math.max(dfs, dfs1 + slices[i]);
    }

}
