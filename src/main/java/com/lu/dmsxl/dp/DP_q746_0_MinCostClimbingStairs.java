package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-05-30
 */
public class DP_q746_0_MinCostClimbingStairs {

    @Test
    public void test() {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] ints = new int[cost.length];
        ints[2] = Math.min(cost[0], cost[1]);
        if (cost.length == 3) {
            return ints[2];
        }
        ints[3] = Math.min(ints[2] + cost[2], cost[1]);
        for (int i = 4; i < cost.length; i++) {
            ints[i] = Math.min(cost[i - 1] + ints[i - 1], cost[i - 2] + ints[i - 2]);
        }
        return ints[cost.length - 1];
    }

}
