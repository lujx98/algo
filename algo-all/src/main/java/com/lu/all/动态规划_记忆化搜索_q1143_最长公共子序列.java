package com.lu.all;

import com.lu.all.图论_并查集_DFS_q1971;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class 动态规划_记忆化搜索_q1143_最长公共子序列 {

    @Test
    public void test() {
        String a = new String("abcde");
        String b = new String("ace");
        System.out.println(longestCommonSubsequence(a, b));
    }

    private int[][] memo;
    private String text1;
    private String text2;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.memo = new int[text1.length()][text2.length()];
        for (int[] ints : this.memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, 0);
    }

    private int dfs(int index1, int index2) {
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }
        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }
        int ans = dfs(index1 + 1, index2);
        if (text1.charAt(index1) == text2.charAt(index2)) {
            ans = Math.max(ans, dfs(index1 + 1, index2 + 1) + 1);
        }
        ans = Math.max(ans, dfs(index1, index2 + 1));

        return memo[index1][index2] = ans;
    }

//
//    public int longestCommonSubsequence1(String text1, String text2) {
//        int[] dp = new int[text2.length() + 1];
//        for (int i = 1; i <= text1.length(); i++) {
//            char c = text1.charAt(i - 1);
//            int pre = dp[0];
//            for (int j = 1; j <= text2.length(); j++) {
//                char c1 = text2.charAt(j - 1);
//                int cur = dp[j];
//                if (c==c1) {
//                    dp[j] = pre + 1;
//                } else {
//                    dp[j] = Math.max(dp[j], dp[j - 1]);
//                }
//                pre = cur;
//            }
//        }
//        return dp[text2.length()];
//    }

//
//    public int longestCommonSubsequence(String text1, String text2) {
//        //int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
//        //        for (int i = 1 ; i <= text1.length() ; i++) {
//        //            char char1 = text1.charAt(i - 1);
//        //            for (int j = 1; j <= text2.length(); j++) {
//        //                char char2 = text2.charAt(j - 1);
//        //                if (char1 == char2) { // 开始列出状态转移方程
//        //                    dp[i][j] = dp[i - 1][j - 1] + 1;
//        //                } else {
//        //                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//        //                }
//        //            }
//        //        }
//        //        return dp[text1.length()][text2.length()];
//
//        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//        for (int i = 1; i <= text1.length(); i++) {
//            char c = text1.charAt(i - 1);
//            for (int j = 1; j <= text2.length(); j++) {
//                char c1 = text2.charAt(j - 1);
//                if (Objects.equals(c,c1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[text1.length()][text2.length()];
//    }

}
