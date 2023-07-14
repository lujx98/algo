package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-11-26
 */
public class 动态规划_选还是不选_记忆化搜索_q115_不同的子序列 {

    @Test
    public void test() {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    private String s;
    private String t;
    private int[][] memo;

    public int numDistinct(String s, String t) {
        this.memo = new int[s.length()][t.length()];
        for (int[] ints : this.memo) {
            Arrays.fill(ints, -1);
        }
        this.s = s;
        this.t = t;
        return dfs(0, 0);
    }

    private int dfs(int is, int it) {
        if (it == t.length()) {
            return 1;
        }
        if (is == s.length()) {
            return 0;
        }
        if (memo[is][it] != -1) {
            return memo[is][it];
        }
        int res = dfs(is + 1, it);
        if (s.charAt(is) == t.charAt(it)) {
            res += dfs(is + 1, it + 1);
        }
        return memo[is][it] = res;
    }

//    public int numDistinct(String s, String t) {
//        int[][] dp = new int[t.length() + 1][s.length() + 1];
//        Arrays.fill(dp[0], 1);
//        for (int i = 1; i <= t.length(); i++) {
//            for (int j = 1; j <= s.length(); j++) {
//                if (t.charAt(i - 1) == s.charAt(j - 1)) {
//                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = dp[i][j - 1];
//                }
//            }
//        }
//
//        return dp[t.length()][s.length()];
//    }

}
