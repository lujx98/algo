package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-11-29
 */
public class q1758_1 {

    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        int max1 = 0;
        for (int i = 0; i < chars.length; i++) {
            {
                //start with 0
                if (i % 2 == 0) {
                    if (chars[i] != '0') {
                        max1++;
                    }
                } else {
                    if (chars[i] != '1') {
                        max1++;
                    }
                }
            }
        }
        return Math.min(max1, chars.length - max1);
    }

    @Test
    public void test() {
        System.out.println(minOperations1("0100"));
    }

    public int minOperations1(String s) {
        //dp[i][1]表示第i位为 1 的时候的最小操作数
        //dp[i][1]表示第i位为 0 的时候的最小操作数
        int length = s.length();
        int[][] dp = new int[length + 1][2];
        for (int i = 1; i <= length; i++) {
            char c = s.charAt(i - 1);
            dp[i][0] = dp[i - 1][1] + (c == '0' ? 0 : 1);
            dp[i][1] = dp[i - 1][0] + (c == '0' ? 1 : 0);
        }
        return Math.min(dp[length][0], dp[length][1]);
    }

}
