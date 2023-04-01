package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-03-29
 */
public class 动态规划_q1641 {

    @Test
    public void test() {
        System.out.println(countVowelStrings(2));
        System.out.println(countVowelStrings(33));
    }

    public int countVowelStrings(int n) {
        //前一位为i时  以j为结尾的个数
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            dp[0] = dp[0]+dp[1]+dp[2]+dp[3]+dp[4];
            dp[1] = dp[1]+dp[2]+dp[3]+dp[4];
            dp[2] = dp[2]+dp[3]+dp[4];
            dp[3] = dp[3]+dp[4];
            dp[4] = dp[4];
        }
        return Arrays.stream(dp).sum();
    }

}
