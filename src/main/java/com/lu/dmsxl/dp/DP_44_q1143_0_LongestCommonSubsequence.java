package com.lu.dmsxl.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class DP_44_q1143_0_LongestCommonSubsequence {

    @Test
    public void test() {
        String a = new String("asdds");
        String b = new String("adwfw");
        System.out.println(a.charAt(0)==b.charAt(0));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        //int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
        //        for (int i = 1 ; i <= text1.length() ; i++) {
        //            char char1 = text1.charAt(i - 1);
        //            for (int j = 1; j <= text2.length(); j++) {
        //                char char2 = text2.charAt(j - 1);
        //                if (char1 == char2) { // 开始列出状态转移方程
        //                    dp[i][j] = dp[i - 1][j - 1] + 1;
        //                } else {
        //                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //                }
        //            }
        //        }
        //        return dp[text1.length()][text2.length()];

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char c = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char c1 = text2.charAt(j - 1);
                if (Objects.equals(c,c1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
