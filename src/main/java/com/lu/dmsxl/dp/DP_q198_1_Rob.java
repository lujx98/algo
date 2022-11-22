package com.lu.dmsxl.dp;

import org.junit.Test;

import java.util.Collections;
import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class DP_q198_1_Rob {

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2}));
    }

    public int rob1(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;


        return dp[nums.length];
    }

    /**
     * dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }

}
