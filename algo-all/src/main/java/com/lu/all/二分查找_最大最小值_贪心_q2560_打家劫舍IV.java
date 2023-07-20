package com.lu.all;

import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * @author sheldon
 * @date 2023-07-18
 */
public class 二分查找_最大最小值_贪心_q2560_打家劫舍IV {

    @Test
    public void test() {
        System.out.println(minCapability(new int[]{2, 3, 5, 9}, 2));
    }

    public int minCapability(int[] nums, int k) {
        int left = nums[0], right = nums[0];
        for (int num : nums) {
            if (num < left) {
                left = num;
            }
            if (num > right) {
                right = num;
            }
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int mid, int k) {
        int cur = 0;
        int pprev = -2;
        for (int i = 0; i < nums.length; i++) {
            if (i - pprev > 1 && nums[i] <= mid) {
                cur++;
                pprev = i;
            }
        }
        return cur >= k;
    }

}
