package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-11-26
 */
public class 动态规划_记忆化搜索_q583_两个字符串的删除操作 {

    private String word1, word2;
    private int[][] memo;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.memo = new int[word1.length()][word2.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        int dfs = dfs(0, 0);
        return word1.length() + word2.length() - 2 * dfs;
    }

    private int dfs(int index1, int index2) {
        if (index1 == word1.length() || index2 == word2.length()) {
            return 0;
        }
        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }
        int ans = 0;
        if (word1.charAt(index1) == word2.charAt(index2)) {
            ans = Math.max(ans, dfs(index1 + 1, index2 + 1) + 1);
        }
        ans = Math.max(ans, dfs(index1 + 1, index2));
        ans = Math.max(ans, dfs(index1, index2 + 1));
        return memo[index1][index2] = ans;
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
