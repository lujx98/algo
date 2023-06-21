package com.lu.all;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.util.Map;

/**
 * @author sheldon
 * @date 2023-06-21
 */
public class q2742 {

    @Test
    public void test() {
        System.out.println(paintWalls(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1}));
    }

    private int[] cost;
    private int[] time;

    public int paintWalls(int[] cost, int[] time) {
        this.cost = cost;
        this.time = time;
        return dfs(0, 0);
    }

    private int dfs(int wall, int freeRemain) {
        if (wall == cost.length - 1) {
            return freeRemain != 0 ? 0 : cost[wall];
        }
        if (cost.length - wall - 1 <= freeRemain) {
            return 0;
        }
        if (wall == cost.length - 1 && time[cost.length - 1] + freeRemain < 0) {
            return Integer.MAX_VALUE;
        }
        int res = dfs(wall + 1, freeRemain + time[wall]) + cost[wall];
        res = Math.min(res, dfs(wall + 1, freeRemain - 1));
        return res;
    }

}
