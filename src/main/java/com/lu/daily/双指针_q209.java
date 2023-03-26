package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-26
 */
public class 双指针_q209 {

    @Test
    public void test() {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int count = nums[0];
        if (count >= target) {
            return 1;
        }
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            count += nums[i];
            if (count >= target) {
                while (count >= target) {
                    count -= nums[left++];
                }
                ans = Math.min(ans, (i - left + 2));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length, ans = n + 1, s = 0, left = 0;
        for (int right = 0; right < n; ++right) {
            s += nums[right];
            while (s >= target) { // 满足要求
                ans = Math.min(ans, right - left + 1);
                s -= nums[left++];
            }
        }
        return ans <= n ? ans : 0;
    }

}
