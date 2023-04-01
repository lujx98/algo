package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-05-30
 */
public class rev_动态规划_q746_MinCostClimbingStairs {

    @Test
    public void test() {
        System.out.println(minCostClimbingStairs(new int[]{1,1,0,0}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] ints = new int[cost.length + 1];
        ints[1] = 0;
        ints[2] = 0;
        for (int i = 3; i < ints.length; i++) {
            ints[i] = Math.min(ints[i - 2] + cost[i - 3], ints[i - 1] + cost[i - 2]);
        }
        return Math.min(ints[ints.length-1] + cost[cost.length - 1], ints[ints.length-2] + cost[cost.length - 2]);
    }

//    public int minCostClimbingStairs(int[] cost) {
//        int[] ints = new int[cost.length];
//        ints[2] = Math.min(cost[0], cost[1]);
//        if (cost.length == 3) {
//            return ints[2];
//        }
//        ints[3] = Math.min(ints[2] + cost[2], cost[1]);
//        for (int i = 4; i < cost.length; i++) {
//            ints[i] = Math.min(cost[i - 1] + ints[i - 1], cost[i - 2] + ints[i - 2]);
//        }
//        return ints[cost.length - 1];
//    }

}
