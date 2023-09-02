package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-11-26
 */
public class 动态规划_序列dp_记忆化搜索_q72_编辑距离 {

    @Test
    public void test() {
        System.out.println(minDistance("intention", "execution"));
    }

    private Integer[][] memo;
    private String word1;
    private String word2;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.memo = new Integer[word1.length()][word2.length()];
        return dfs(0, 0);
    }

    private int dfs(int i1, int i2) {
        if (i2 == word2.length()) {
            return word1.length() - i1;
        }
        if (i1 == word1.length()) {
            return word2.length() - i2;
        }
        if (memo[i1][i2] != null) {
            return memo[i1][i2];
        }
        //删除
        int res = dfs(i1 + 1, i2) + 1;
        if (word1.charAt(i1) == word2.charAt(i2)) {
            res = Math.min(res, dfs(i1 + 1, i2 + 1));
        }
        //替换
        res = Math.min(res, dfs(i1 + 1, i2 + 1) + 1);
        //插入
        res = Math.min(res, dfs(i1, i2 + 1) + 1);
        return memo[i1][i2] = res;
    }


//    public int minDistance(String word1, String word2) {
//        int length = word1.length();
//        int length1 = word2.length();
//        int[][] dp = new int[length + 1][length1 + 1];
//        // 初始化
//        for (int i = 1; i <= length; i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 1; j <= length1; j++) {
//            dp[0][j] = j;
//        }
//        for (int i = 1; i <= length; i++) {
//            char c = word1.charAt(i - 1);
//            for (int j = 1; j <= length1; j++) {
//                char c1 = word2.charAt(j - 1);
//                if (c == c1) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
//                }
//            }
//        }
//        return dp[length][length1];
//    }

}
