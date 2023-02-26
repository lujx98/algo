package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-25
 */
public class q1247_数学规律 {

    @Test
    public void test() {
        System.out.println(minimumSwap("xy", "yx"));
    }

    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if (a == 'x' && b == 'y') {
                xy++;
            }
            if (a == 'y' && b == 'x') {
                yx++;
            }
        }
        if ((xy + yx) % 2 == 1) {
            return -1;
        }
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }

}
