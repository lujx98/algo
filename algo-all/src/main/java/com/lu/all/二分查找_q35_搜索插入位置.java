package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-02-27
 */
public class 二分查找_q35_搜索插入位置 {

    @Test
    public void tes() {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 4));
    }

    public int searchInsert(int[] nums, int target) {
        //这种作法如果没有
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(1);
        return nums[left] >= target ? left : left + 1;
    }

}
