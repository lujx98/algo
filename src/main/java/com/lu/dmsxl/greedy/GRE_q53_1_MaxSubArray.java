package com.lu.dmsxl.greedy;

/**
 * @author sheldon
 * @date 2022-10-06
 */
public class GRE_q53_1_MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }

        return result;
    }

}
