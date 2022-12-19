package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-15
 */
public class q1945_1_模拟 {

    @Test
    public void test() {
        System.out.println(getLucky("vbyytoijnbgtyrjlsc", 2));
    }

    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            stringBuilder.append(c - 'a' + 1);
        }
        s = stringBuilder.toString();

        int num = 0;
        for (int i = 0; i < k; i++) {
            num = 0;
            for (int j = 0; j < s.length(); j++) {
                num += s.charAt(j) - '0';
            }
            s = String.valueOf(num);
        }
        return num;
    }

}
