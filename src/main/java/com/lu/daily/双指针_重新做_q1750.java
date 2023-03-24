package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-28
 */
public class 双指针_重新做_q1750 {

    @Test
    public void test() {
        System.out.println(minimumLength("aabccabba"));
    }

    public int minimumLength(String s) {
        int res = s.length();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            while (s.charAt(right - 1) == s.charAt(right)) {
                right--;
                res -= 1;
            }
            res --;
            while (s.charAt(left + 1) == s.charAt(left)) {
                left++;
                res -= 1;
            }
        }
        return res;
    }

}
