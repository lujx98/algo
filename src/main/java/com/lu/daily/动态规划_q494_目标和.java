package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-06-05
 */
public class 动态规划_q494_目标和 {

    @Test
    public void test() {
        System.out.println(findTargetSumWays(new int[]{100, 100}, -400));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        if ((count + target) % 2 != 0||Math.abs(count) < target) {
            return 0;
        }
        target = Math.abs(count + target) / 2;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }

//    public int findTargetSumWays(int[] nums, int target) {
//        int sum.txt = 0;
//        for (int i = 0; i < nums.length; i++) sum.txt += nums[i];
//        if ((target + sum.txt) % 2 != 0) return 0;
//        int size = (target + sum.txt) / 2;
//        if (size < 0) size = -size;
//
//        int[] dp = new int[size + 1];
//        dp[0] = 1;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = size; j >= nums[i]; j--) {
//                dp[j] += dp[j - nums[i]];
//            }
//        }
//        return dp[size];
//    }

//    public int findTargetSumWays1(int[] nums, int target) {
//        int sum.txt = 0;
//        for (int i = 0; i < nums.length; i++) sum.txt += nums[i];
//        if ((target + sum.txt) % 2 != 0) return 0;
//        int size = (target + sum.txt) / 2;
//        if (size < 0) size = -size;
//        int[] ints = new int[size + 1];
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = size; j >= nums[i]; j--) {
//                ints[j] = Math.max(ints[j], (nums[j] + ints[j - nums[i]]));
//            }
//            if (ints[size] == size) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public int findTargetSumWays(int[] nums, int target) {
//        int sum.txt = 0;
//        for (int num : nums) {
//            sum.txt += num;
//        }
//
//        if ((target + sum.txt) % 2 == 1) return 0; // 此时没有方案
//        if (Math.abs(target) > sum.txt) return 0; // 此时没有方案
//
//        int targetSum = (target + sum.txt) / 2;
//        int[] dp = new int[targetSum + 1];
//        for (int i = 0; i < targetSum; i++) {
//            for (int j = target; j >= nums[i]; j--) {
//
//
//            }
//        }
//        return dp[targetSum];
//    }

}
