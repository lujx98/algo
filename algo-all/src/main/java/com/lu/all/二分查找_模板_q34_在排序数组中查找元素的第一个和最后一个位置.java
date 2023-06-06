package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-06
 */
public class 二分查找_模板_q34_在排序数组中查找元素的第一个和最后一个位置 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int lower = findLower(nums, target);
        if (lower == 0 || nums[lower] != target) {
            lower = -1;
        }
        int i = findLower(nums, target + 1) - 1;
        if (i <= 0 || nums[i] != target) {
            i = -1;
        }
        return new int[]{lower, i};
    }

    private int findLower(int[] nums, int target) {
        int right = nums.length - 1, left = 0;
        while (right >= left) {
            int mid = right + (left - right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
