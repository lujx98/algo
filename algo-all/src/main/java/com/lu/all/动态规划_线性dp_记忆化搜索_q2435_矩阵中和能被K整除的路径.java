package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-29
 */
public class 动态规划_线性dp_记忆化搜索_q2435_矩阵中和能被K整除的路径 {

    @Test
    public void test() {
        System.out.println(numberOfPaths(ArrayUtils.makeIntArraysByString("[[5,2,4],[3,0,5],[0,7,2]]"), 3));
    }

    private int[][][] memo;
    private int[][] grid;
    private int k;
    private static int MOD = (int) 1E9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        this.memo = new int[grid.length][grid[0].length][k];
        for (int[][] ints : this.memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(0, 0, 0);
    }

    private int dfs(int i, int j, int l) {
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (memo[i][j][l] != -1) {
            return memo[i][j][l];
        }
        if (i == grid.length - 1 && grid[0].length - 1 == j && (l + grid[i][j]) % k == 0) {
            return 1;
        }
        int next = (l + grid[i][j] % k) % k;
        int res = dfs(i + 1, j, next) + dfs(i, j + 1, next);
        return memo[i][j][l] = res % MOD;
    }

}
