package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-21
 */
public class 动态规划_q518_零钱兑换II {

    @Test
    public void test(){
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

//    public int change(int amount, int[] coins) {
//        int[] dp = new int[amount + 1];
//        dp[0] = 1;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                dp[j] += dp[j - coins[i]];
//            }
//        }
//        return dp[amount];
//    }

//
//    @Test
//    public void test() {
//        System.out.println(change(5, new int[]{1, 2, 5}));
//    }
//
//    public int change1(int amount, int[] coins) {
//        int[] ints = new int[amount + 1];
//        ints[0] = 1;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                ints[j] += ints[j - coins[i]];
//            }
//        }
//        return ints[amount];
//    }
//
//    public int change(int amount, int[] coins) {
//        int[] ints = new int[amount + 1];
//        ints[0] = 1;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                ints[j] += ints[j - coins[i]];
//            }
//        }
//        return ints[amount];
//    }

}
