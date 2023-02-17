package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-13
 */
public class q1234_没做 {

    @Test
    public void test() {
        System.out.println(balancedString("QQQW"));
    }

    public int balancedString(String s) {
        int[] count = new int[4];
        int res = 0;
        for (char c : s.toCharArray()) {
            int index = 0;
            switch (c) {
                case 'Q':
                    index = 0;
                    break;
                case 'W':
                    index = 1;
                    break;
                case 'E':
                    index = 2;
                    break;
                case 'R':
                    index = 3;
                default:
                    break;
            }
            count[index]++;
        }
        int length = s.length();
        int i1 = length / 4;
        for (int i : count) {
            if (i > i1) {
                res += (i - i1);
            }
        }
        return res;
    }

}
