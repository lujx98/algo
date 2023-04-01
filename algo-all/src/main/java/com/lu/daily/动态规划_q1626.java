package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-03-22
 */
public class 动态规划_q1626 {

    @Test
    public void test() {
        System.out.println(bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, ans = 0;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; ++i)
            ids[i] = i;
        Arrays.sort(ids, (i, j) -> scores[i] != scores[j] ? scores[i] - scores[j] : ages[i] - ages[j]);

        int[] dp = new int[ages.length + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ages[ids[i]] > ages[ids[j]]) {
                    dp[i] = dp[j] + scores[ids[i]];
                    res = Math.max(res,dp[i]);
                }
            }
        }
        return res;
    }

}
