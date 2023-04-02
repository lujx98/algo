package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-02
 */
public class 记忆化搜索_q1039_多边形三角剖分的最低得分 {

    @Test
    public void test() {
        System.out.println(minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
    }

    private int[][] memo;
    private int[] values;

    public int minScoreTriangulation(int[] values) {
        this.values = values;
        memo = new int[values.length][values.length];
        return dfs(0, values.length - 1);
    }

    private int dfs(int head, int tail) {
        if (tail - head == 1) {
            return 0;
        }
        if (memo[head][tail] != 0) {
            return memo[head][tail];
        }

        int res = Integer.MAX_VALUE;
        for (int i = head + 1; i < tail; i++) {
            res = Math.min(res, dfs(head, i) + dfs(i, tail) + (values[head] * values[tail] * values[i]));
        }

        return memo[head][tail] = res;
    }

}
