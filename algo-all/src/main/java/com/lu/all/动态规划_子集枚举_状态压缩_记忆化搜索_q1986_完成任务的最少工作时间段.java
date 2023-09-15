package com.lu.all;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class 动态规划_子集枚举_状态压缩_记忆化搜索_q1986_完成任务的最少工作时间段 {

    private int sessionTime;
    private int[] sum;
    private Integer[][] memo;

    public int minSessions(int[] tasks, int sessionTime) {
        this.sum = new int[1 << tasks.length];
        this.memo = new Integer[tasks.length][1 << tasks.length];
        for (int i = 0; i < sum.length; i++) {
            int curSum = 0;
            for (int j = 0; j < tasks.length; j++) {
                if ((i & (1 << j)) != 0) {
                    curSum += tasks[j];
                }
            }
            sum[i] = curSum;
        }
        this.sessionTime = sessionTime;
        return dfs(0, (1 << tasks.length) - 1);
    }

    private int dfs(int cur, int mask) {
        if (mask == 0) {
            return cur;
        }
        if (memo[cur][mask]!=null) {
            return memo[cur][mask];
        }
        int res = Integer.MAX_VALUE;
        for (int i = mask; i > 0; i = (i - 1) & mask) {
            if (sum[i] <= sessionTime) {
                res = Math.min(res, dfs(cur + 1, mask ^ i));
            }
        }
        return memo[cur][mask] = res;
    }

}
