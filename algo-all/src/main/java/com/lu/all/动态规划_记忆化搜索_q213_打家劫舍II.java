package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-03
 */
public class 动态规划_记忆化搜索_q213_打家劫舍II {

    @Test
    public void test(){
        System.out.println(rob(new int[]{1,3,1,3,100}));
    }

    private int[][] memo;
    private int[] nums;

    public int rob(int[] nums) {
        this.memo = new int[nums.length][2];
        for (int[] i : this.memo) {
            Arrays.fill(i, -1);
        }
        this.nums = nums;
        return Math.max(dfs(2, 1) + nums[0], dfs(1, 0));
    }

    private int dfs(int i, int  first) {
        if (i == nums.length - 1 && first==1) {
            return 0;
        }
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i][first] != -1) {
            return memo[i][first];
        }
        int res = dfs(i + 1, first);
        return memo[i][first] = Math.max(res, dfs(i + 2, first) + nums[i]);
    }

}

