package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class 动态规划_子集枚举_状态压缩_记忆化搜索_q2305_公平分发饼干 {

    @Test
    public void test() {
        System.out.println(distributeCookies(new int[]{8, 15, 10, 20, 8}, 2));
    }

    private int[] sum;
    private int k;
    private Integer[][] memo;

    public int distributeCookies(int[] cookies, int k) {
        this.k = k;
        this.sum = new int[1 << cookies.length];
        this.memo = new Integer[k][1 << cookies.length];

        for (int i = 0; i < sum.length; i++) {
            int curSum = 0;
            for (int j = 0; j < cookies.length; j++) {
                if ((i & (1 << j)) != 0) {
                    curSum += cookies[j];
                }
            }
            sum[i] = curSum;
        }

        return dfs(0, (1 << cookies.length) - 1);
    }

    private int dfs(int index, int mask) {
        if (index == k) {
            if (mask == 0) {
                return 0;
            } else {
                return -1;
            }
        }
        if (memo[index][mask] != null) {
            return memo[index][mask];
        }
        int res = Integer.MAX_VALUE;
        for (int i = mask; i > 0; i = (i - 1) & mask) {
            int dfs = dfs(index + 1, mask ^ i);
            if (dfs == -1) {
                continue;
            }
            int cur = Math.max(this.sum[i], dfs);
            res = Math.min(res, cur);
        }
        return memo[index][mask] = res;
    }

}
