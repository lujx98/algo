package com.lu.dmsxl.dp;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-11-26
 */
public class DP_50_q72_0_MinDistance {

    public int minDistance(String word1, String word2) {
        int length = word1.length();
        int length1 = word2.length();
        int[][] dp = new int[length + 1][length1 + 1];
        // 初始化
        for (int i = 1; i <= length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= length1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= length; i++) {
            char c = word1.charAt(i - 1);
            for (int j = 1; j <= length1; j++) {
                char c1 = word2.charAt(j - 1);
                if (c == c1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[length][length1];
    }
}
