package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author sheldon
 * @date 2022-11-27
 */
public class 记忆化搜索_q516_最长回文子序列 {

    //https://zhuanlan.zhihu.com/p/509207705
    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq("ababac"));
    }

    private int[][] memo;

    public int longestPalindromeSubseq(String s) {
        this.memo = new int[s.length()][s.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, s.length() - 1, s);
    }

    private int dfs(int head, int tail, String s) {
        if (tail < head) {
            return 0;
        }
        if (tail == head) {
            return 1;
        }
        if (memo[head][tail] != -1) return memo[head][tail];

        if (s.charAt(head) == s.charAt(tail)) {
            return memo[head][tail] = dfs(head + 1, tail - 1, s) + 2;
        }
        return memo[head][tail] = Math.max(dfs(head + 1, tail, s), dfs(head, tail - 1, s));
    }

    //
    public int longestPalindromeSubseq1(String s) {
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
