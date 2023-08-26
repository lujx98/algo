package com.lu.all;

import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-07-30
 */
public class 动态规划_状态机dp_记忆化搜索_q2826_将三个组排序 {

    @Test
    public void test() {
        System.out.println(minimumOperations(Arrays.asList(2, 1, 3, 2, 1)));
    }

    private List<Integer> nums;
    private int[][] memo;

    public int minimumOperations(List<Integer> nums) {
        this.nums = nums;
        Integer integer = nums.get(0);
        int res;
        this.memo = new int[nums.size()][4];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        if (integer == 1) {
            res = Math.min(dfs(0, 2), dfs(0, 3)) + 1;
        } else if (integer == 2) {
            res = Math.min(dfs(0, 1), dfs(0, 3)) + 1;
        } else {
            res = Math.min(dfs(0, 2), dfs(0, 1)) + 1;
        }
        return Math.min(res, dfs(0, integer));
    }

    private int dfs(int cur, int s) {
        if (cur == nums.size() - 1) {
            return 0;
        }
        if (memo[cur][s] != -1) {
            return memo[cur][s];
        }
        Integer sNext = nums.get(cur + 1);
        int res = Integer.MAX_VALUE;
        for (int i = s; i < 4; i++) {
            if (i == sNext) {
                res = Math.min(res, dfs(cur + 1, i));
            } else {
                res = Math.min(res, dfs(cur + 1, i) + 1);
            }
        }
        return memo[cur][s] = res;
    }

}
