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
        int start = lowerBound(nums, target); // 选择其中一种写法即可
        if (start == nums.length || nums[start] != target)
            return new int[]{-1, -1};
        // 如果 start 存在，那么 end 必定存在
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private int lowerBound(int[] nums, int i) {
        int left = 0, right = nums.length - 1;


        return 0;
    }
}
