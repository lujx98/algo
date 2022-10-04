package com.lu.dmsxl.dp;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class DP_q674_1_FindLengthOfLCIS {

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
