package com.lu.all;

import org.junit.Test;

import java.util.List;

/**
 * @author sheldon
 * @date 2023-08-14
 */
public class 双指针_q2818_到最近的人的最大距离 {

    @Test
    public void test() {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
    }

    public int maxDistToClosest(int[] seats) {
        int left = -1;
        int res = 0;
        for (int right = 0; right < seats.length; right++) {
            if (seats[right] == 1) {
                if (left == -1) {
                    res = right;
                } else {
                    res = Math.max(res, (right - left) / 2);
                }
                left = right;
            }
        }
        return Math.max(res, seats.length - left - 1);
    }

}
