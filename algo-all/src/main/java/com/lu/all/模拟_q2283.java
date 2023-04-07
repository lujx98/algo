package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-11
 */
public class 模拟_q2283 {

    @Test
    public void test() {
        System.out.println(digitCount("1210"));
    }

    public boolean digitCount(String num) {
        char[] chars = num.toCharArray();
        int[] frequency = new int[chars.length];
        for (char c : chars) {
            int i = c - '0';
            if (i >= chars.length) {
                return false;
            }
            frequency[i]++;
        }
        for (int i = 0; i < frequency.length; i++) {
            if (chars[i] - '0' != frequency[i]) {
                return false;
            }
        }
        return true;
    }

}
