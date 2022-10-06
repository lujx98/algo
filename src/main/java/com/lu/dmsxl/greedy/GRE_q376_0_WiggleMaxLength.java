package com.lu.dmsxl.greedy;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-06
 */
public class GRE_q376_0_WiggleMaxLength {

    @Test
    public void test() {
        System.out.println(wiggleMaxLength1(new int[]{3, 3, 3, 2, 5}));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    public int wiggleMaxLength1(int[] nums) {
        int[][] dp = new int[nums.length][2];

        dp[0][0] = dp[0][1] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] < 0) {
                dp[i][0] = Math.max(dp[i - 1][0] + 1, dp[i][0]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1] + 1, dp[i][1]);
            }
        }

        return Math.max(dp[nums.length - 1][1], dp[nums.length - 1][0]);
    }

}
