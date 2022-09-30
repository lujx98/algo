package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-21
 */
public class DP_q518_1_Change {

    @Test
    public void test(){
        System.out.println(change(5,new int[]{1,2,5}));
    }

    public int change(int amount, int[] coins) {
        int[] ints = new int[amount + 1];
        ints[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                ints[j] += ints[j - coins[i]];
            }
        }
        return ints[amount];
    }

}
