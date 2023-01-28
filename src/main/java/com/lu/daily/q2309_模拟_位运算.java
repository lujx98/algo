package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-28
 */
public class q2309_模拟_位运算 {

    @Test
    public void test() {
        System.out.println(greatestLetter("arRAzFif"));
    }

    public String greatestLetter(String s) {
        int upperMask = 0;
        int lowercaseMask = 0;
        char[] chars = s.toCharArray();
        char r = 'A' - 1;
        for (char c : chars) {
            if ('a' <= c && 'z' >= c) {
                if (((upperMask >> (c - 'a')) & 1) == 1) {
                    char c1 = Character.toUpperCase(c);
                    if (c1 > r) {
                        r = c1;
                    }
                }
                lowercaseMask |= 1 << c - 'a';
                continue;
            }
            if ('A' <= c && 'Z' >= c) {
                if (((lowercaseMask >> (c - 'A')) & 1) == 1) {
                    if (c > r) {
                        r = c;
                    }
                }
                upperMask |= 1 << c - 'A';
            }
        }
        if (r == 'A' - 1) {
            return "";
        }
        return String.valueOf(r);
    }

}
