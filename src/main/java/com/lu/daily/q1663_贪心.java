package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-29
 */
public class q1663_贪心 {

    @Test
    public void test() {
        System.out.println(getSmallestString(5, 73));
        System.out.println(getSmallestString(3, 27));
    }

    public String getSmallestString(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
//            1 25 26 2 26 52
//            3 71 78 4 72 104
            if (k <= (n - 1) * 26) {
                stringBuilder.append('a');
                n--;
                k--;
            } else {
                char c = (char) ('a' - 1 + k - (n - 1) * 26);
                stringBuilder.append(c);
                k -= (k - (n - 1) * 26);
                while (k > 0) {
                    stringBuilder.append('z');
                    k -= 26;
                }
                break;
            }
        }
        return stringBuilder.toString();
    }

}
