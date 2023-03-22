package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-21
 */
public class rev_动态规划_q1824 {

    @Test
    public void test() {
        System.out.println(minSideJumps(new int[]{0, 1, 2, 3, 0}));
    }

    public int minSideJumps(int[] obstacles) {
        //dp[i][j] 表示 青蛙在i处 j道时 的最小侧跳次数
        //初始化：dp[0][i]  只有当i为1的时候的时候侧跳次数为0 其余为1
        //dp公式：
        //当前道前方没有障碍：dp[i][j] = dp[i-1][j]
        //当前道前方有障碍：dp[i][j] = Integer.MAX; dp[i][other] = min(dp[i-1][all] + 1);
        int length = obstacles.length;
        int[][] dp = new int[length][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 1;
        for (int i = 1; i < length; i++) {
            int curO = obstacles[i] - 1;
            boolean hasObs = curO != 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (curO == j) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    min = Math.min(min, dp[i - 1][j]);
                }
            }
            for (int j = 0; j < 3; j++) {
                if (curO == j) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], min + 1);
            }
        }
        return Math.min(dp[length - 1][0], Math.min(dp[length - 1][1], dp[length - 1][2]));
    }

}
