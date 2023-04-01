package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-12-21
 */
public class 贪心_模拟_q1753 {

    @Test
    public void test() {
        System.out.println(maximumScore(2, 4, 6));
        System.out.println(maximumScore(4, 4, 6));
        System.out.println(maximumScore(1, 8, 8));
    }

    public int maximumScore(int a, int b, int c) {
            int[] ints = {a, b, c};
            Arrays.sort(ints);
            int res = 0;
            if (ints[0] + ints[1] >= ints[2]) {
                res = ints[2] + (ints[0] + ints[1] - ints[2]) / 2;
            } else {
                res += (ints[0] + ints[1]);
            }
            return res;
    }

}
