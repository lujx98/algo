package com.lu.all;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;
import sun.security.krb5.internal.KdcErrException;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-08-10
 */
public class 动态规划_线性dp_记忆化搜索_q1289_下降路径最小和II {

    @Test
    public void test() {
        System.out.println(minFallingPathSum(new int[][]{{7}}));
    }

    private int[][] memo;
    private int[][] grid;

    public int minFallingPathSum(int[][] grid) {
        this.memo = new int[grid.length][grid[0].length];
        int res = Integer.MAX_VALUE;
        this.grid = grid;
        for (int[] ints : this.memo) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int i = 0; i < grid[0].length; i++) {
            res = Math.min(res, dfs(0, i));
        }
        return res;
    }

    public int dfs(int depth, int index) {
        if (depth >= grid.length) {
            return 0;
        }
        if (memo[depth][index] != Integer.MAX_VALUE) {
            return memo[depth][index];
        }
        int cur = grid[depth][index];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            if (i == index) {
                continue;
            }
            res = Math.min(res, dfs(depth + 1, i));
        }
        return memo[depth][index] = cur + (res == Integer.MAX_VALUE ? 0 : res);
    }

}
