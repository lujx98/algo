package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-26
 */
public class 动态规划_线性dp_选还是不选_记忆化搜索_q2786_访问数组中的位置使分数最大 {

    private int x;
    private int[] nums;
    private long[][] memo;

    public long maxScore(int[] nums, int x) {
        this.memo = new long[nums.length][2];
        for (long[] ints : this.memo) {
            Arrays.fill(ints, -1);
        }
        this.x = x;
        this.nums = nums;
        return dfs(1, nums[0] % 2) + nums[0];
    }

    private long dfs(int index, int prev) {
        if (index == nums.length) {
            return 0;
        }
        if (memo[index][prev] != -1) {
            return memo[index][prev];
        }
        long res = dfs(index + 1, prev);
        long offset = nums[index] % 2 == prev ? 0 : -x;
        return memo[index][prev] = Math.max(res, nums[index] + dfs(index + 1, nums[index] % 2) + offset);
    }

}
