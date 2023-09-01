package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-09-01
 */
public class 动态规划_数位dp_二进制_记忆化搜索_q600_含连续1的非负整数 {

    @Test
    public void test() {
        System.out.println(findIntegers(4));
    }


    private Integer[][][] memo;
    private String n;

    public int findIntegers(int n) {
        this.n = Integer.toString(n, 2);
        this.memo = new Integer[this.n.length()][2][2];
        return dfs(0, 0, 1);
    }

    private int dfs(int index, int isOne, int isLimit) {
        if (index == n.length()) {
            return 1;
        }
        if (memo[index][isOne][isLimit] != null) {
            return memo[index][isOne][isLimit];
        }
        int res = 0;
        int up = isLimit == 1 ? n.charAt(index) - '0' : 1;
        for (int i = 0; i <= up; i++) {
            if (i == 1 && isOne == 1) {
                continue;
            }
            int isNextLimit = isLimit == 1 ? (n.charAt(index) - '0' == i ? 1 : 0) : 0;
            res += dfs(index + 1, i == 1 ? 1 : 0, isNextLimit);
        }
        return memo[index][isOne][isLimit] = res;
    }

}
