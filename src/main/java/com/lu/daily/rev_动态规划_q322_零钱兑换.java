package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-09-30
 */
public class rev_动态规划_q322_零钱兑换 {

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{2}, 3));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

//    public int coinChange1(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
//                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//                }
//            }
//        }
//        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
//    }
//
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
//                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//                }
//            }
//        }
//        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
//    }

}
