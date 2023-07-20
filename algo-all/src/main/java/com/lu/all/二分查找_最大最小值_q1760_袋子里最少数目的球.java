package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-12-20
 */
public class 二分查找_最大最小值_q1760_袋子里最少数目的球 {

    @Test
    public void test() {
        int start = Integer.MAX_VALUE - 1;
        int end = Integer.MAX_VALUE - 1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println((start + end) >>> 1);
        System.out.println(start + (end - start) / 2);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int res = 0;
        while (left < right) {
            int a = left + (right - left) / 2;
            if (can(nums, a) <= maxOperations) {
                left = a;
            } else {
                right = a;
            }
        }
        return res;
    }

    private int can(int[] nums, int a) {
        return 1;
    }

//    public int minimumSize(int[] nums, int maxOperations) {
//        int left = 1, right = Arrays.stream(nums).max().getAsInt();
//        int res = 0;
//        while (left <= right) {
//            int g = left + (right - left) / 2;
//            int ops = 0;
//            for (int num : nums) {
//                ops += (num - 1) / g;
//            }
//            if (ops > maxOperations) {
//                left = g + 1;
//            } else {
//                res = g;
//                right = g - 1;
//            }
//        }
//        return res;
//    }

}
