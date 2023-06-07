package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-07
 */
public class 二分查找_q162_寻找峰值 {

    @Test
    public void test() {
        System.out.println(findPeakElement1(new int[]{1, 2}));
    }

    public int findPeakElement1(int[] nums) {
        return 0;
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid != nums.length - 1 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
