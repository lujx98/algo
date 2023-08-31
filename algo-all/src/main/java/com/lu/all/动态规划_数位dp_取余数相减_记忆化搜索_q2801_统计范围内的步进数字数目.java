package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-08-31
 */
public class 动态规划_数位dp_取余数相减_记忆化搜索_q2801_统计范围内的步进数字数目 {

    @Test
    public void test() {
        System.out.println(countSteppingNumbers("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"
                , "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"
        ));
    }

    private static final int MOD = (int) 1e9 + 7;
    private Long[][][][] memo;

    public int countSteppingNumbers(String low, String high) {
        this.memo = new Long[high.length()][11][2][2];
        long lo = dfs(0, 10, 1, 0, low);
        this.memo = new Long[high.length()][11][2][2];
        long hi = dfs(0, 10, 1, 0, high);
        int i = (int) ((hi - lo + is(low)) % MOD);
        return (i + MOD) % MOD;
    }

    private long is(String low) {
        for (int i = 1; i < low.length(); i++) {
            if (Math.abs(low.charAt(i) - low.charAt(i - 1)) != 1) {
                return 0L;
            }
        }
        return 1L;
    }

    public long dfs(int index, int prev, int isLimit, int isNum, String num) {
        if (index >= num.length()) {
            return isNum == 1 ? 1 : 0;
        }
        if (memo[index][prev][isLimit][isNum] != null) {
            return memo[index][prev][isLimit][isNum];
        }
        int up = isLimit == 1 ? num.charAt(index) - '0' : 9;
        long res = 0;
        for (int i = 0; i <= up; i++) {
            if (prev != 10 && Math.abs(i - prev) != 1) {
                continue;
            }
            int isNextLimit = isLimit == 1 ? (num.charAt(index) - '0' == i ? 1 : 0) : 0;
            int isNextNum = isNum == 1 ? 1 : (i == 0 ? 0 : 1);
            int nextPrev = isNextNum == 0 ? 10 : i;
            res = (res + (dfs(index + 1, nextPrev, isNextLimit, isNextNum, num) % MOD)) % MOD;
        }
        return memo[index][prev][isLimit][isNum] = res;
    }

}
