package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-11-27
 */
public class DP_53_q516_0_LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

}
