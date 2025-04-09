package com.lu.contest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class bc3 {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubsequence(Arrays.asList(1, 2, 3, 4, 5), 9));
    }


    private int[][] memo;
    private List<Integer> nums;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        this.memo = new int[nums.size()][target + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        this.nums = nums;
        int dfs = dfs(0, target);
        return dfs == Integer.MIN_VALUE ? -1 : dfs;
    }

    private int dfs(int index, int target) {
        if (target == 0) {
            return 0;
        }
        if (index == nums.size() || target < 0) {
            return Integer.MIN_VALUE;
        }
        if (memo[index][target] != -1) {
            return memo[index][target];
        }
        int res = dfs(index + 1, target);


        int dfs1 = dfs(index + 1, target - nums.get(index));
        if (dfs1 != Integer.MIN_VALUE) {
            res = Math.max(res, dfs1 + 1);
        }
        return memo[index][target] = res;
    }

}
