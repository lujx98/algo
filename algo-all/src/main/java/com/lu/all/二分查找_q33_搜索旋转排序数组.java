package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-07
 */
public class 二分查找_q33_搜索旋转排序数组 {

    @Test
    public void test() {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

}
