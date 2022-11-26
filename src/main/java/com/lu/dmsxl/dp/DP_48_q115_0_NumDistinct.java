package com.lu.dmsxl.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-11-26
 */
public class DP_48_q115_0_NumDistinct {

    @Test
    public void test(){
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }

}
