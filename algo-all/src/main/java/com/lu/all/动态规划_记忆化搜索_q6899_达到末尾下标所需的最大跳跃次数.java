package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-09
 */
public class 动态规划_记忆化搜索_q6899_达到末尾下标所需的最大跳跃次数 {

    @Test
    public void test() {
        System.out.println(maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2));
    }

    private int[] nums;
    private int target;
    private int[] memo;

    public int maximumJumps(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int dfs = dfs(0);
        return dfs == Integer.MIN_VALUE ? -1 : dfs;
    }

    private int dfs(int i) {
        if (memo[i] != -1) {
            return memo[i];
        }
        if (i == nums.length - 1) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[j] - nums[i]) <= target) {
                int dfs = dfs(j);
                if (dfs != Integer.MIN_VALUE) {
                    res = Math.max(dfs + 1, res);
                }
            }
        }
        return memo[i] = res;
    }

}
