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
        System.out.println(minimumSize(new int[]{9}, 2));
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int a, int maxOperations) {
        for (int num : nums) {
            if (num > a) {
                maxOperations -= (((num + a - 1) / a) - 1);
            }
        }
        return maxOperations >= 0;
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
