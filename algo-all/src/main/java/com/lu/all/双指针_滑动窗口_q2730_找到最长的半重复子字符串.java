package com.lu.all;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-07-07
 */
public class 双指针_滑动窗口_q2730_找到最长的半重复子字符串 {

    @Test
    public void test() {
        System.out.println(longestSemiRepetitiveSubstring("52233"));
    }

    public int longestSemiRepetitiveSubstring(String s) {
        int left = 0, sum = 0, res = 1;
        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                sum++;
            }
            if (sum == 2) {
                left++;
                while (left < s.length() && s.charAt(left) != s.charAt(left - 1)) {
                    left++;
                }
                sum = 1;
            }
            res = Math.max(res, right - left+1);
        }
        return res;
    }

}
