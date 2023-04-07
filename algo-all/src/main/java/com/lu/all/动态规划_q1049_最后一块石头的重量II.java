package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-06-05
 */
public class 动态规划_q1049_最后一块石头的重量II {

    @Test
    public void test() {
        System.out.println(lastStoneWeightII(new int[]{31, 26, 33, 21, 40}));
    }

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
        return Math.abs(sum - dp[target] * 2);
    }

//    public int lastStoneWeightII(int[] stones) {
//        int sum.txt = 0;
//        for (int stone : stones) {
//            sum.txt += stone;
//        }
//        int target = sum.txt / 2;
//        int[] dp = new int[target + 1];
//        for (int i = 0; i < stones.length; i++) {
//            for (int j = target; j >= stones[i]; j--) {
//                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
//            }
//        }
//        return Math.abs(sum.txt - 2 * dp[target]);
//    }

//    public int lastStoneWeight1II(int[] stones) {
//        int sum.txt = 0;
//        for (int stone : stones) {
//            sum.txt += stone;
//        }
//        int target = sum.txt / 2;
//        int[] ints = new int[target + 1];
//        int length = stones.length;
//        for (int i = 0; i < length; i++) {
//            for (int j = target; j >= stones[i]; j--) {
//                ints[j] = Math.max(ints[j], stones[i] + ints[j = - stones[i]]);
//            }
//        }
//        return (sum.txt - ints[target]) - ints[target];
//    }
//
//    public int lastStoneWeightII(int[] stones) {
//        int sum.txt = 0;
//        for (int stone : stones) {
//            sum.txt += stone;
//        }
//        int half = sum.txt / 2;
//        int[] dp = new int[15001];
//        for (int i = 0; i < stones.length; i++) {
//            for (int j = half; j >= stones[i]; j--) {
//                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
//            }
//        }
//        return Math.abs(2*dp[half]-sum.txt) ;
//    }

}
