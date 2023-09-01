package com.lu.all;

/**
 * @author sheldon
 * @date 2023-09-01
 */
public class 动态规划_数位dp_记忆化搜索_q233_数字1的个数 {

    private String n;
    private Integer[][][][] memo;

    public int countDigitOne(int n) {
        this.n = String.valueOf(n);
        this.memo = new Integer[this.n.length()][this.n.length()][2][2];
        return dfs(0, 0, 1, 0);
    }

    private int dfs(int index, int count, int isLimit, int isNum) {
        if (index == n.length()) {
            return isNum == 1 ? count : 0;
        }
        if (memo[index][count][isLimit][isNum] != null) {
            return memo[index][count][isLimit][isNum];
        }
        int up = isLimit == 1 ? n.charAt(index) - '0' : 9;
        int res = 0;
        for (int i = 0; i <= up; i++) {
            int isNextNum = isNum == 1 ? 1 : (i == 0 ? 0 : 1);
            int isNextLimit = isLimit == 1 ? (n.charAt(index) - '0' == i ? 1 : 0) : 0;
            res += dfs(index + 1, i == 1 ? count + 1 : count, isNextLimit, isNextNum);
        }
        return memo[index][count][isLimit][isNum] = res;
    }

}
