package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-06-05
 */
public class DP_14_q1049_1_LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return Math.abs(sum - 2 * dp[target]);
    }

//    public int lastStoneWeight1II(int[] stones) {
//        int sum = 0;
//        for (int stone : stones) {
//            sum += stone;
//        }
//        int target = sum / 2;
//        int[] ints = new int[target + 1];
//        int length = stones.length;
//        for (int i = 0; i < length; i++) {
//            for (int j = target; j >= stones[i]; j--) {
//                ints[j] = Math.max(ints[j], stones[i] + ints[j = - stones[i]]);
//            }
//        }
//        return (sum - ints[target]) - ints[target];
//    }
//
//    public int lastStoneWeightII(int[] stones) {
//        int sum = 0;
//        for (int stone : stones) {
//            sum += stone;
//        }
//        int half = sum / 2;
//        int[] dp = new int[15001];
//        for (int i = 0; i < stones.length; i++) {
//            for (int j = half; j >= stones[i]; j--) {
//                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
//            }
//        }
//        return Math.abs(2*dp[half]-sum) ;
//    }

}
