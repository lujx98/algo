package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-06-05
 */
public class DP_q494_0_FindTargetSumWays {

    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        target = sum / 2;
        int[] ints = new int[target + 1];

        return 0;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((target + sum) % 2 == 1) return 0; // 此时没有方案
        if (Math.abs(target) > sum) return 0; // 此时没有方案

        int targetSum = (target + sum) / 2;
        int[] dp = new int[targetSum + 1];
        for (int i = 0; i < targetSum; i++) {
            for (int j = target; j >= nums[i]; j--) {

            }
        }
        return dp[targetSum];
    }

}
