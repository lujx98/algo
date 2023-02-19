package com.lu.dmsxl.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class DP_42_q674_1_FindLengthOfLCIS {

    @Test
    public void test() {
        System.out.println(findLengthOfLCIS2(new int[]{1, 3, 5, 4, 7}));
    }

    public int findLengthOfLCIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }

    public int findLengthOfLCIS1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(dp[i], max);
            } else {
                dp[i] = 1;
            }
        }
        return max;
    }

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                if (dp[i] > res) {
                    res = dp[i];
                }
            }
        }
        return res;
    }

}
