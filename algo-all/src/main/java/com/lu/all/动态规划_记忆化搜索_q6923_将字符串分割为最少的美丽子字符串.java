package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-08
 */
public class 动态规划_记忆化搜索_q6923_将字符串分割为最少的美丽子字符串 {

    @Test
    public void test() {
        System.out.println(minimumBeautifulSubstrings("1011"));
    }

    private int[] memo;
    private String s;

    public int minimumBeautifulSubstrings(String s) {
        if (s.charAt(0) == '0') {
            return -1;
        }
        this.memo = new int[s.length()];
        Arrays.fill(memo, -1);
        this.s = s;
        int dfs = dfs(0);
        return dfs == Integer.MAX_VALUE ? -1 : dfs;
    }

    public int dfs(int index) {
        if (index >= s.length()) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        if (s.charAt(index) == '0') {
            return Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            Integer integer = Integer.valueOf(substring, 2);
            if (check(integer)) {
                int dfs = dfs(i);
                if (dfs != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + dfs);
                }
            }
        }
        return memo[index] = res;
    }

    public boolean check(int i) {
        if (i == 1) {
            return true;
        }
        if (i % 5 != 0) {
            return false;
        }
        int temp = 5;
        int i1 = 0;
        while (Math.pow(temp, i1) <= i) {
            if ((int) Math.pow(temp, i1) == i) {
                return true;
            }
            i1++;
        }
        return false;
    }

}
