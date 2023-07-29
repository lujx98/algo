package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-29
 */
public class 动态规划_路径dp_记忆化搜索_q1463_摘樱桃II {

    @Test
    public void test() {
        System.out.println(cherryPickup(ArrayUtils.makeIntArraysByString("[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]")));
    }

    private int[][][] memo;
    private int[][] grid;
    private int[] temp = new int[]{-1, 0, 1};

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.memo = new int[grid.length][grid[0].length][grid[0].length];
        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(0, 0, grid[0].length - 1);
    }

    private int dfs(int x, int y1, int y2) {
        if (x > grid.length - 1 ||
                y1 > grid[0].length - 1 ||
                y2 > grid[0].length - 1 ||
                x < 0 ||
                y1 < 0 ||
                y2 < 0) {
            return 0;
        }
        if (memo[x][y1][y2] != -1) {
            return memo[x][y1][y2];
        }
        int gain = grid[x][y1] + grid[x][y2];
        if (y1 == y2) {
            gain = grid[x][y1];
        }
        int res = 0;
        for (int p1 : temp) {
            for (int p2 : temp) {
                res = Math.max(res, dfs(x + 1, y1 + p1, y2 + p2));
            }
        }
        return memo[x][y1][y2] = gain + res;
    }

}
