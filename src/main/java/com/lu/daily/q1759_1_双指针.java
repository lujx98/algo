package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-31
 */
public class q1759_1_双指针 {

    private static final int MOD = (int) 1e9 + 7;

    @Test
    public void test() {
        System.out.println(countHomogenous("abbcccaa"));
    }

    public int countHomogenous1(String s) {
        int n = s.length();
        long ans = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                ++j;
            }
            int cnt = j - i;
            ans += (long) (1 + cnt) * cnt / 2;
            ans %= MOD;
        }
        return (int) ans;
    }

    public int countHomogenous(String s) {
        long res = 0;
        for (int left = 0, right = 0; left < s.length();) {
            right = left;
            while (left < s.length() && s.charAt(right) == s.charAt(left)) {
                left++;
            }
            int div = left - right;
            res += (long)div * (div + 1) / 2;
            res %= MOD;
        }
        return (int)res;
    }

}
