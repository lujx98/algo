package com.lu.all;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @author sheldon
 * @date 2023-06-21
 */
public class 动态规划_线性dp_选还是不选_记忆化搜索_q2742_给墙壁刷油漆 {

    @Test
    public void test() {
        System.out.println(paintWalls(new int[]{49, 35, 32, 20, 30, 12, 42}, new int[]{1, 1, 2, 2, 1, 1, 2}));
    }

    private int[] cost;
    private int[] times;
    private int[][] memo;

    public int paintWalls(int[] cost, int[] time) {
        this.cost = cost;
        this.times = time;
        memo = new int[cost.length][1002];
        for (int[] ints : this.memo) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        return dfs(0, 0);
    }

    private int dfs(int wall, int time) {
        if (cost.length - wall <= time) {
            return 0;
        }
        if (wall == cost.length - 1) {
            if (-time > times[wall]) {
                return Integer.MAX_VALUE;
            } else {
                return cost[wall];
            }
        }
        if (memo[wall][time + 500] != Integer.MIN_VALUE) {
            return memo[wall][time + 500];
        }
        int dfs = dfs(wall + 1, time + times[wall]);
        int res = Integer.MAX_VALUE;
        if (dfs != Integer.MAX_VALUE) {
            res = dfs + cost[wall];
        }
        res = Math.min(res, dfs(wall + 1, time - 1));
        return memo[wall][time + 500] = res;
    }

}
