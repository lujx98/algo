package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-05-09
 */
public class 模拟_q2437_有效时间的数目 {

    @Test
    public void test() {
        System.out.println(countTime("?4:22"));
    }

    public int countTime(String time) {
        int res = 1;
        char c5 = time.charAt(4);
        if (c5 == '?') {
            res *= 10;
        }
        char c4 = time.charAt(3);
        if (c4 == '?') {
            res *= 6;
        }
        char c1 = time.charAt(1);
        char c0 = time.charAt(0);
        if (c1 == '?' && c0 == '?') {
            res *= 24;
        }
        if (c1 == '?' && c0 != '?') {
            if (c0 == '2') {
                res *= 4;
            } else {
                res *= 10;
            }
        }
        if (c1 != '?' && c0 == '?') {
            if (c1 - '0' > 3) {
                res *= 2;
            } else {
                res *= 3;
            }
        }

        return res;
    }

}
