package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-31
 */
public class 双指针_哈希表_q2367_算术三元组的数目 {
    //两种做法 双指针滑动窗口 和 哈希表
    @Test
    public void test() {
        System.out.println(arithmeticTriplets(new int[]{6, 14, 15, 26, 31, 36, 38, 41, 42, 45}, 5));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0, right = 0, right2 = 0;
        int targett = nums[0] + diff;
        int targett2 = nums[0] + 2 * diff;
        if (nums[nums.length - 1] < targett2) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= targett) {
                right = i;
            }
            if (nums[i] <= targett2) {
                right2 = i;
            }
        }
        if (nums[right] - nums[0] == diff && nums[right2] - nums[right] == diff) {
            res++;
        }
        for (int left = 1; left < nums.length && right < nums.length && right2 < nums.length; left++) {
            int target = nums[left] + diff;
            int target2 = nums[left] + 2 * diff;

            while (right < nums.length && nums[right] <= target && nums[right] != target) {
                right++;
            }

            while (right2 < nums.length && nums[right2] <= target2 && nums[right2] != target2) {
                right2++;
            }
            if (right2 < nums.length && nums[right] - nums[left] == diff && nums[right2] - nums[right] == diff) {
                res++;
            }
        }
        return res;
    }

}
