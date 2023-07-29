package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-07-29
 */
public class rev_动态规划_线性dp_次数和最大值同时求_记忆化搜索_q1301_最大得分的路径数目 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(pathsWithMaxScore(Arrays.asList("E23", "2X2", "12S"))));
    }

    private char[][] chars;
    private final int[][] d = new int[3][2];
    private int[][][] memo;
    private final int MOD = (int)1e9 + 7;

    public int[] pathsWithMaxScore(List<String> board) {
        this.chars = new char[board.size()][board.get(0).length()];
        for (int i = 0; i < board.size(); i++) {
            chars[i] = board.get(i).toCharArray();
        }
        this.memo = new int[chars[0].length][chars.length][2];
        d[0] = new int[]{-1, 0};
        d[1] = new int[]{0, -1};
        d[2] = new int[]{-1, -1};
        int[] dfs = dfs(chars[0].length - 1, chars.length - 1);
        if (dfs == null) {
            return new int[]{0, 0};
        } else {
            dfs[1] /= 2;
            return dfs;
        }
    }

    private int[] dfs(int x, int y) {
        if (x == 0 && y == 0) {
            return new int[]{0, 1};
        }
        if (x < 0 || y < 0 || y > chars.length - 1 || chars[x][y] == 'X') {
            return null;
        }
        if (memo[x][y][1] != 0) {
            return memo[x][y];
        }
        int[] res = null;
        for (int[] ints : d) {
            int dx = ints[0];
            int dy = ints[1];
            int[] dfs = dfs(x + dx, y + dy);
            if (dfs == null) {
                continue;
            }
            if (res == null || dfs[0] > res[0]) {
                res = dfs;
            } else if (dfs[0] == res[0]) {
                res[1] += dfs[1]%MOD;
                res[1]%=MOD;
            }
        }
        if (res == null) {
            return null;
        }
        int cur;
        if (chars[x][y] == 'S') {
            cur = 0;
        } else {
            cur = chars[x][y] - '0';
        }
        res[0] += cur;
        return memo[x][y] = res;
    }

}
