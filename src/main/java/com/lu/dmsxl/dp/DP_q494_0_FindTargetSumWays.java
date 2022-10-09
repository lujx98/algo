package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-06-05
 */
public class DP_q494_0_FindTargetSumWays {

    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if (size < 0) size = -size;
        int[] ints = new int[size + 1];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                ints[j] = Math.max(ints[j], (nums[j] + ints[j - nums[i]]));
            }
            if (ints[size] == size) {
                count++;
            }
        }
        return count;
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
