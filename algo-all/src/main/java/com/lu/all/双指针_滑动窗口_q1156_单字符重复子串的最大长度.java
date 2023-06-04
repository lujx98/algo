package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-03
 */
public class 双指针_滑动窗口_q1156_单字符重复子串的最大长度 {

    @Test
    public void test() {
        System.out.println(maxRepOpt1("abcdef"));
    }

    public int maxRepOpt1(String text) {
        if (text.length() == 1) {
            return 1;
        }
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        for (int left = 1; left < text.toCharArray().length; left++) {
            int cur = left - 1;
            while (left < text.length() && text.charAt(left) == text.charAt(left - 1)) {
                left++;
            }
            int leftLength = left - cur;
            if (count[text.charAt(cur) - 'a'] > leftLength) {
                int right = left + 1;
                while (right < text.length() && text.charAt(right) == text.charAt(cur)) {
                    right++;
                }
                int rightLength = right - left - 1;
                int b = rightLength + leftLength + 1;
                b = b > count[text.charAt(cur) - 'a'] ? count[text.charAt(cur) - 'a'] : b;
                res = Math.max(res, b);
            } else {
                res = Math.max(res, leftLength);
            }
        }

        return res;
    }

}
