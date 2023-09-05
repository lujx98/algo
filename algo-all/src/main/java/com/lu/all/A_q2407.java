package com.lu.all;

/**
 * @author sheldon
 * @date 2023-08-18
 */
public class A_q2407 {

    private int k;
    private int[] nums;
    private Integer[][] memo;

    public int lengthOfLIS(int[] nums, int k) {
        this.nums = nums;
        this.memo = new Integer[nums.length][nums.length];
        this.k = k;
        return dfs(-1, 0);
    }

    private int dfs(int prev, int cur) {
        if (cur >= nums.length) {
            return 0;
        }
        if (prev != -1 && memo[prev][cur] != null) {
            return memo[prev][cur];
        }
        int res = dfs(prev, cur + 1);
        if (prev == -1 || nums[cur] - nums[prev] <= k && nums[cur] > nums[prev]) {
            res = Math.max(res, dfs(cur, cur + 1) + 1);
        }
        if (prev != -1) {
            return memo[prev][cur] = res;
        }
        return res;
    }

}
