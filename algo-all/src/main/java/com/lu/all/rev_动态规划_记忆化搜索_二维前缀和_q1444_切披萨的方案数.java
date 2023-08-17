package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-08-17
 */
public class rev_动态规划_记忆化搜索_二维前缀和_q1444_切披萨的方案数 {

    @Test
    public void test() {
        System.out.println(ways(new String[]{".A..A", "A.A..", "A.AA.", "AAAA.", "A.AA."}, 5));
    }

    private String[] pizza;
    private static final int MOD = (int) 1E9 + 7;
    private int[][][][] memo;

    public int ways(String[] pizza, int k) {
        this.pizza = pizza;
        this.memo = new int[pizza.length][pizza.length][pizza[0].length()][pizza[0].length()];
        for (int[][][] ints : memo) {
            for (int[][] anInt : ints) {
                for (int[] ints1 : anInt) {
                    Arrays.fill(ints1, -1);
                }
            }
        }
        return dfs(0, pizza.length - 1, 0, pizza[0].length() - 1, k - 1);
    }

    private int dfs(int x1, int x2, int y1, int y2, int k) {
        if (memo[x1][x2][y1][y2] != -1) {
            return memo[x1][x2][y1][y2];
        }
        if (k == 0) {
            return 1;
        }
        int res = 0;
        for (int i = x1 + 1; i <= x2; i++) {
            if (check(x1, i - 1, y1, y2) && check(i, x2, y1, y2)) {
                res += (dfs(i, x2, y1, y2, k - 1) % MOD);
            }
        }
        res %= MOD;
        for (int i = y1 + 1; i <= y2; i++) {
            if (check(x1, x2, y1, i - 1) && check(x1, x2, i, y2)) {
                res += (dfs(x1, x2, i, y2, k - 1) % MOD);
            }
        }
        return memo[x1][x2][y1][y2] = res % MOD;
    }

    private boolean check(int x1, int x2, int y1, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    return true;
                }
            }
        }
        return false;
    }

}
