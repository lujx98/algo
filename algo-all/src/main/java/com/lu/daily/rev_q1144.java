package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-27
 */
public class rev_q1144 {

    @Test
    public void test() {
        System.out.println(movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }

    public int movesToMakeZigzag(int[] nums) {
        int[] s = new int[2];
        for (int i = 0, n = nums.length; i < n; ++i) {
            int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i < n - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            s[i % 2] += Math.max(nums[i] - Math.min(left, right) + 1, 0);
        }
        return Math.min(s[0], s[1]);
    }

}