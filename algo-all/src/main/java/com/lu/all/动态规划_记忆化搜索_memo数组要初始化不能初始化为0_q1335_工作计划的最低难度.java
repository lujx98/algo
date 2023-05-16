package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-05-16
 */
public class 动态规划_记忆化搜索_memo数组要初始化不能初始化为0_q1335_工作计划的最低难度 {

    @Test
    public void test() {
        System.out.println(minDifficulty(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 10));
    }

    private int[] jobDifficulty;
    private int[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        this.memo = new int[jobDifficulty.length + 1][d + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        this.jobDifficulty = jobDifficulty;
        return dfs(0, d);
    }

    private int dfs(int index, int div) {
        if (memo[index][div] != -1) {
            return memo[index][div];
        }
        if (div == 1) {
            int res = Integer.MIN_VALUE;
            for (int i = index; i < jobDifficulty.length; i++) {
                res = Math.max(jobDifficulty[i], res);
            }
            return memo[index][div] = res;
        }
        int res = Integer.MAX_VALUE;
        int curMax = jobDifficulty[index];
        for (int i = index + 1; i < jobDifficulty.length - div + 2; i++) {
            int curDiff = dfs(i, div - 1);
            res = Math.min(curMax + curDiff, res);
            curMax = Math.max(curMax, jobDifficulty[i]);
        }
        return memo[index][div] = res;
    }

}
