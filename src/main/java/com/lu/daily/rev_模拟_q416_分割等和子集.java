package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-06-05
 */
public class rev_模拟_q416_分割等和子集 {

    @Test
    public void test(){
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
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
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

//    public boolean canPartition2(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if (sum % 2 == 1) {
//            return false;
//        }
//        int target = sum / 2;
//        int[] dp = new int[target + 1];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = target; j > nums[i]; j--) {
//                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
//            }
//        }
//        return dp[target] == target;
//    }
//
//    public boolean canPartition1(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if (sum % 2 == 1) {
//            return false;
//        }
//        int target = sum / 2;
//        int[] dp = new int[target + 1];
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = target; j >= nums[i]; j--) {
//                dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
//            }
//        }
//        return dp[target] == target;
//    }

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
