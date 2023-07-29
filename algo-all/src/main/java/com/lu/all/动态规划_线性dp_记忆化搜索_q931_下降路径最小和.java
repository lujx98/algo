package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-13
 */
public class 动态规划_线性dp_记忆化搜索_q931_下降路径最小和 {

    @Test
    public void test() {
        System.out.println(minFallingPathSum(ArrayUtils.makeIntArraysByString("[[2,1,3],[6,5,4],[7,8,9]]")));
    }

    private int[][] matrix;
    private int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        int res = Integer.MAX_VALUE;
        this.memo = new int[matrix.length][matrix[0].length];
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            res = Math.min(res, dfs(0, i));
        }
        return res;
    }

    private int dfs(int x, int y) {
        if (y < 0 || y >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (x == matrix.length - 1) {
            return matrix[x][y];
        }
        if (memo[x][y] != Integer.MAX_VALUE) {
            return memo[x][y];
        }
        int res = dfs(x + 1, y - 1);
        res = Math.min(res, dfs(x + 1, y));
        res = Math.min(res, dfs(x + 1, y + 1));
        return memo[x][y] = res + matrix[x][y];
    }

}
