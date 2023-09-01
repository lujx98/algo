package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-09-01
 */
public class 动态规划_数位dp_记忆化搜索_q2827_范围中美丽整数的数目 {

    @Test
    public void test() {
        System.out.println(numberOfBeautifulIntegers(1, 10, 1));
    }

    private int MOD;
    private Integer[][][][][] memo;

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.MOD = k;
        int length = String.valueOf(high).length();
        this.memo = new Integer[2 * length + 1][k + 1][2 * length + 1][2][2];
        int dfs = dfs(0, 0, 0, 1, 0, String.valueOf(high));
        this.memo = new Integer[2 * length + 1][k + 1][2 * length + 1][2][2];
        int dfs1 = dfs(0, 0, 0, 1, 0, String.valueOf(low));
        return dfs - dfs1 + check(low);
    }

    private int check(int low) {
        String s = String.valueOf(low);
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                a++;
            } else {
                a--;
            }
        }
        return (a == 0 && low % MOD == 0) ? 1 : 0;
    }

    private int dfs(int index, int mod, int diff, int isLimit, int isNum, String num) {
        if (index == num.length()) {
            return mod == 0 && diff == 0 && isNum == 1 ? 1 : 0;
        }
        if (memo[index][mod][diff + num.length()][isLimit][isNum] != null) {
            return memo[index][mod][diff + num.length()][isLimit][isNum];
        }
        int res = 0;
        int up = isLimit == 1 ? num.charAt(index) - '0' : 9;
        for (int i = 0; i <= up; i++) {
            int isNextNum = isNum == 0 ? (i == 0 ? 0 : 1) : 1;
            int isNextLimit = isLimit == 0 ? 0 : (i == num.charAt(index) - '0' ? 1 : 0);
            int nextMod = (mod * 10 + i) % MOD;
            int nextDiff = isNextNum == 1 ? (i % 2 == 1 ? diff - 1 : diff + 1) : 0;
            res += dfs(index + 1, nextMod, nextDiff, isNextLimit, isNextNum, num);
        }
        return memo[index][mod][diff + num.length()][isLimit][isNum] = res;
    }

}
