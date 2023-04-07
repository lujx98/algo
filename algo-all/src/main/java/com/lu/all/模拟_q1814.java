package com.lu.all;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author sheldon
 * @date 2023-01-17
 */
public class 模拟_q1814 {

    @Test
    public void test() {
        int[] ints = {};
        for (int anInt : ints) {
            if (getReverse(anInt) != Integer.parseInt(new StringBuilder(String.valueOf(anInt)).reverse().toString())) {
                System.out.println(anInt);
            }
        }
    }


    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(Math.abs(num - getReverse(num)), 1, Integer::sum);
        }
        Integer res = 0;
        for (Integer value : map.values()) {
            res += (value * (value - 1) / 2) %1000000007;
        }
        return res;
    }

    private int getReverse(int num) {
        int temp = num, j = 0;
        while (temp > 0) {
            j = j * 10 + temp % 10;
            temp /= 10;
        }
        return j;
    }

}
