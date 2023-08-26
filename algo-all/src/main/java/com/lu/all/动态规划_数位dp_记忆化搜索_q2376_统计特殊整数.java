package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-08-26
 */
public class 动态规划_数位dp_记忆化搜索_q2376_统计特殊整数 {

    @Test
    public void test() {
        System.out.println(countSpecialNumbers(20));
    }

    private String n;
    private Integer[][][][] memo;

    public int countSpecialNumbers(int n) {
        this.n = String.valueOf(n);
        int i = 1 << 10;
        this.memo = new Integer[this.n.length()][i][2][2];
        return dfs(0, 0, 1, 0);
    }

    public int dfs(int index, int mask, int isLimit, int isNum) {
        if (index == n.length()) {
            return isNum == 1 ? 1 : 0;
        }
        if (memo[index][mask][isLimit][isNum] != null) {
            return memo[index][mask][isLimit][isNum];
        }
        int up = isLimit == 1 ? n.charAt(index) - '0' : 9;
        int down = isNum == 1 ? 0 : 1;
        int res = isNum == 1 ? 0 : dfs(index + 1, mask, 0, 0);
        for (int i = down; i <= up; i++) {
            if ((mask & (1 << i)) == 0) {
                if (isLimit == 1 && n.charAt(index) - '0' == i) {
                    res += dfs(index + 1, mask | (1 << i), isLimit, 1);
                } else {
                    res += dfs(index + 1, mask | (1 << i), 0, 1);
                }
            }
        }
        return memo[index][mask][isLimit][isNum] = res;
    }

}
