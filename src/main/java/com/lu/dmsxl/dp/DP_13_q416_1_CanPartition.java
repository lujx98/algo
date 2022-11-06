package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-06-05
 */
public class DP_13_q416_1_CanPartition {

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j > nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
            }
        }
        return dp[target] == target;
    }

//    public boolean canPartition1(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if (sum % 2 != 0) {
//            return false;
//        }
//        int target = sum / 2;
//        int[] ints = new int[target + 1];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = target; j >= nums[i]; j--) {
//                ints[j] = Math.max(ints[j], ints[j - nums[i]] + nums[i]);
//            }
//        }
//        return ints[target]==target;
//    }
//
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if (sum % 2 == 1) {
//            return false;
//        }
//        int target = sum / 2;
//
//        int[] dp = new int[target + 1];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = target; j >= nums[i]; j--) {
//                dp[j] = Math.max(dp[i], dp[j - nums[i]] + nums[i]);
//            }
//        }
//
//        return dp[target] == target;
//    }

}
