package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-26
 */
public class 动态规划_线性dp_选还是不选_记忆化搜索_q2787_将一个数字表示成幂的和的方案数 {

    @Test
    public void test() {
        System.out.println(numberOfWays(4, 1));
    }

    private final int MOD = (int) 1E9 + 7;
    private int n, x;
    private int[][] memo;

    public int numberOfWays(int n, int x) {
        this.n = n;
        this.x = x;
        this.memo = new int[n + 1][300];
        for (int[] ints : this.memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(1, n);
    }

    private int dfs(int cur, int remain) {
        if (remain == 0) {
            return 1;
        }
        if (remain < 0 || cur > n) {
            return 0;
        }
        if (memo[cur][remain] != -1) {
            return memo[cur][remain];
        }
        int res = dfs(cur + 1, remain - (int) (Math.pow(cur, x)));
        res += dfs(cur + 1, remain);
        return memo[cur][remain] = (res % MOD);
    }

}
