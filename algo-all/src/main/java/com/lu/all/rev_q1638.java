package com.lu.all;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/count-substrings-that-differ-by-one-character/
 *
 * @author sheldon
 * @date 2023-03-27
 */
public class rev_q1638 {

    @Test
    public void test() {
        System.out.println(countSubstrings("abbab", "bbbbb"));
    }

    public int countSubstrings(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //dp[i][j] 表示 到s字符串i与到t字符串的j位 的答案

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int sp = i, tp = j;
                int dif = 0;
                for (; sp < s.length() && tp < t.length(); sp++, tp++) {
                    if (s.charAt(sp) == t.charAt(tp)) {
                        if (dif == 1) {
                            ans++;
                        }
                    }else {
                        dif++;
                        if (dif == 2) {
                            break;
                        }
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

}
