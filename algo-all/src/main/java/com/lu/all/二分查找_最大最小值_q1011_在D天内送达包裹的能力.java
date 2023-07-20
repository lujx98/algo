package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-12
 */
public class 二分查找_最大最小值_q1011_在D天内送达包裹的能力 {

    @Test
    public void test() {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, weights, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int mid, int[] weights, int days) {
        int curLoad = mid;
        for (int weight : weights) {
            if (days < 0) {
                return false;
            }
            if (weight > mid) {
                return false;
            }
            if (curLoad == 0 || weight > curLoad) {
                days--;
                curLoad = mid;
            }
            curLoad -= weight;
        }
        return days > 0;
    }

}
