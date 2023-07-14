package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-11-27
 */
public class 动态规划_记忆化搜索_q647_回文子串 {

    @Test
    public void test() {
        System.out.println(countSubstrings("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"));
    }

    private int[][] memo;
    private String s;

    public int countSubstrings(String s) {
        this.memo = new int[s.length()][s.length()];
        this.s = s;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                res += dfs(i, j);
            }
        }
        return res;
    }

    private int dfs(int i, int j) {
        if (i >= j) {
            return 1;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        return memo[i][j] = s.charAt(i) == s.charAt(j) ? dfs(i + 1, j - 1) : 0;
    }


//    private boolean[][] memo;
//    private String s;

//    public int countSubstrings(String s) {
//        memo = new boolean[s.length()][s.length()];
//        this.s = s;
//        return dfs(0, s.length() - 1);
//    }
//
//    private int dfs(int head, int tail) {
//        if (memo[head][tail]) {
//            return 0;
//        }
//        int res = 0;
//        if (tail == head) {
//            memo[head][tail] = true;
//            return 1;
//        }
//        if (!memo[head][tail] && isS(head, tail)) {
//            memo[head][tail] = true;
//            res++;
//        }
//        for (int i = head; i <= tail; i++) {
//            for (int j = i; j <= tail; j++) {
//                if (s.charAt(i)!=s.charAt(j)) {
//                    memo[i][j] = true;
//                    continue;
//                }
//                if ((i == head && j == tail)) {
//                    continue;
//                }
//                res += memo[i][j] ? 0 : dfs(i, j);
//            }
//        }
//        return res;
//    }
//
//    private boolean isS(int head, int tail) {
//        while (head < tail) {
//            if (s.charAt(head) != s.charAt(tail)) {
//                return false;
//            }
//            head++;
//            tail--;
//        }
//        return true;
//    }

//    public int countSubstrings(String s) {
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int count = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            char r = s.charAt(i);
//            for (int j = i; j < s.length(); j++) {
//                char c = s.charAt(j);
//                if (r == c) {
//                    if (j - i > 1) {
//                        if (dp[i + 1][j - 1]) {
//                            dp[i][j] = true;
//                            count++;
//                        } else {
//                            dp[i][j] = false;
//                        }
//                    } else {
//                        dp[i][j] = true;
//                        count++;
//                    }
//                } else {
//                    dp[i][j] = false;
//                }
//            }
//        }
//        return count;
//    }

}
