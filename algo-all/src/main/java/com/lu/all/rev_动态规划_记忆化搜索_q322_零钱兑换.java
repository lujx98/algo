package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-30
 */
public class rev_动态规划_记忆化搜索_q322_零钱兑换 {

    @Test
    public void test() {
        System.out.println(coinChange(new int[]{2}, 3));
    }


    private int[] memo;
    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        this.memo = new int[amount + 1];
        this.coins = coins;
        int dfs = dfs(amount);
        return dfs == Integer.MAX_VALUE ? -1 : dfs;
    }

    private int dfs(int amount) {
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                res = Math.min(res, 1 + dfs(amount - coins[i]));
            }
        }
        return memo[amount] = res;
    }

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
//        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
//    }

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
