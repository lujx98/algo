package com.lu.daily;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sheldon
 * @date 2022-11-24
 */
public class q795_1 {

    @Test
    public void test() {
        System.out.println(numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8));
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0] <= right && nums[0] >= left ? 1 : 0;
        int k = (nums[0] >= left) ? 0 : -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > right) {
                dp[i] = 0;
            } else if (nums[i] < left) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + (i - k - 1) + 1;
            }
            if (nums[i] >= left) {
                k = i;
            }

        }
        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }

}
