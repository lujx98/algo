package com.lu.all;

import com.lu.all.图论_并查集_DFS_q1971;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class 动态规划_打家劫舍_记忆化搜索_q198_打家劫舍 {

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2}));
    }

    private int[] memo;
    private int[] nums;

    public int rob(int[] nums) {
        this.memo = new int[nums.length];
        Arrays.fill(memo, -1);
        this.nums = nums;
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = dfs(i + 1);
        return memo[i] = Math.max(res, dfs(i + 2) + nums[i]);
    }

//    /**
//     * dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1])
//     *
//     * @param nums
//     * @return
//     */
//    public int rob(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int[] dp = new int[nums.length + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        dp[2] = Math.max(nums[0], nums[1]);
//        for (int i = 3; i <= nums.length; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
//        }
//        return dp[nums.length];
//    }

}
