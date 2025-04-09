package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-10-29
 */
public class q123 {

    @Test
    public void test() {
        System.out.println(Arrays.stream(new int[]{0,16,28,12,10,15,25,24,6,0,0}).sum());
        System.out.println(minSum(new int[]{20,15,19,5,6,29,25,8,12}, new int[]{1, 4}));
    }

    public long minSum(int[] nums1, int[] nums2) {
        long zero1 = 0;
        long sum1 = 0;
        for (int i : nums1) {
            if (i == 0) {
                zero1++;
            } else {
                sum1 += i;
            }
        }
        long zero2 = 0;
        long sum2 = 0;
        for (int i : nums2) {
            if (i == 0) {
                zero2++;
            } else {
                sum2 += i;
            }
        }
        if (sum1 == sum2) {
            if (zero1 != 0 && zero2 != 0) {
                return Math.max(zero2 + sum2, zero1 + sum1);
            } else {
                return -1;
            }
        }
        if (sum1+zero1 < sum2+zero2) {
            if (zero1 == 0) {
                return -1;
            }
            if (zero2 == 0 && zero1 + sum1 > sum2) {
                return -1;
            }
            return sum2 + zero2;
        } else {
            if (zero2 == 0) {
                return -1;
            }
            if (zero1 == 0 && zero2 + sum2 > sum1) {
                return -1;
            }
            return sum1 + zero1;
        }
    }

}
