package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-25
 */
public class q6471 {

    @Test
    public void test() {
        System.out.println(makeTheIntegerZero(3, -2));
    }

    public int makeTheIntegerZero(int num1, int num2) {
        if (num2 > num1) {
            return -1;
        }
        for (int i = 1; i < (num2 / num1 + 1); i++) {
            if (check(i, num1 - num2 * i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean check(int times, int pow) {
        return Integer.bitCount(pow) == times;
    }

}
