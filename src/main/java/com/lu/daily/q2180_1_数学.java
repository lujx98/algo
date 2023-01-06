package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-06
 */
public class q2180_1_数学 {

    @Test
    public void test() {
        System.out.println(countEven(13));
        System.out.println(countEven(30));
        System.out.println(countEven(4));
    }

    public int countEven(int num) {
        int ans = num / 10 * 5 - 1;
        int s = 0;
        for (int x = num / 10; x > 0; x /= 10) {
            s += x % 10;
        }
        ans += (num % 10 + 2 - (s & 1)) >> 1;
        return ans;
    }

}
