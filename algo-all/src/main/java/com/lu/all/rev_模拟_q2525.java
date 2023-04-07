package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-08
 */
public class rev_模拟_q2525 {

    @Test
    public void test(){
        System.out.println(categorizeBox(3223, 1271, 2418, 749));
        System.out.println(categorizeBox(200, 50, 800, 50));
    }

    public String categorizeBox(int length, int width, int height, int mass) {
        if ((length > 1e4 || width > 1e4 || height > 1e4) || is(length, width, height)) {
            if (mass >= 100) {
                return "Both";
            } else {
                return "Bulky";
            }
        } else {
            if (mass >= 100) {
                return "Heavy";
            } else {
                return "Neither";
            }
        }
    }

    private boolean is(int length, int width, int height) {
        if ((long) length * (long) width > 1e9) {
            return true;
        }
        long l = (long) length * (long) width * (long) height;
        return l >= 1e9;
    }

}
