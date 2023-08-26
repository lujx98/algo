package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-08-26
 */
public class 快速幂_分治_q50_pow {

    @Test
    public void test(){
        System.out.println(myPow(2, 10));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long nn = n;
        return n > 0 ? q(x, nn) : 1 / q(x, -nn);
    }

    public double q(double x, long n) {
        double ans = 1D;
        double contri = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= contri;
            }
            contri *= contri;
            n /= 2;
        }
        return ans;
    }

}
