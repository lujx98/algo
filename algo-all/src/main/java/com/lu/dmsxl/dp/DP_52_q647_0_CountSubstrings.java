package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-11-27
 */
public class DP_52_q647_0_CountSubstrings {

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char r = s.charAt(i);
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (r == c) {
                    if (j - i > 1) {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            count++;
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        dp[i][j] = true;
                        count++;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return count;
    }

}
