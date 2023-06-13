package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-13
 */
public class 二分查找_q287_寻找重复数 {

    @Test
    public void test() {
        System.out.println(findDuplicate(new int[]{2,2,2,2,2}));
    }

    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
