package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-12-20
 */
public class q1760_1_二分查找 {

    @Test
    public void test(){
        int start = Integer.MAX_VALUE-1;
        int end = Integer.MAX_VALUE-1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println((start + end) >>> 1);
        System.out.println(start + (end - start) / 2);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int res = 0;
        while (left <= right) {
            int g = left + (right - left) / 2;
            int ops = 0;
            for (int num : nums) {
                ops += (num - 1) / g;
            }
            if (ops > maxOperations) {
                left = g + 1;
            } else {
                res = g;
                right = g - 1;
            }
        }
        return res;
    }

}
