package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-07-02
 */
public class 模拟_q2765_最长交替子序列 {

    @Test
    public void test() {
        System.out.println(longestAlternatingSubarray(new int[]{2,3,4,5}, 4));
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        for (int left = 0, right = 0; left < nums.length; left++) {
            right = left;
            if (nums[left] <= threshold && nums[left] % 2 == 0) {
                right = left + 1;
                while (right < nums.length && ((nums[right] & 1) ^ (nums[right - 1] & 1)) == 1 && nums[right] <= threshold) {
                    right++;
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
