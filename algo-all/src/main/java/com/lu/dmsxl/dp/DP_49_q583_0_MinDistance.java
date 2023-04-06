package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-11-26
 */
public class DP_49_q583_0_MinDistance {

    private int[][] memo;

    public int minDistance(String word1, String word2) {


        return 0;
    }

    private int dfs(int head, int tail) {
        return 0;
    }

//    public int minDistance1(String word1, String word2) {
//        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//        for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
//        for (int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;
//
//        for (int i = 1; i <= word1.length(); i++) {
//            for (int j = 1; j <= word2.length(); j++) {
//                if (word1.charAt(i - 1) == word2.charAt(i - 1)) {
//
//                }
//            }
//        }
//
//        return dp[word1.length()][word2.length()];
//    }
//
//    public int minDistance(String word1, String word2) {
//        int length = word1.length();
//        int length1 = word2.length();
//        int[][] dp = new int[length + 1][length1 + 1];
//        for (int i = 1; i <= length; i++) {
//            char c = word1.charAt(i - 1);
//            for (int j = 1; j <= length1; j++) {
//                char c1 = word2.charAt(j - 1);
//                if (c == c1) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//                }
//            }
//        }
//
//        return length + length1 - dp[length][length1]<<1;
//    }

}
