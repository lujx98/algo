package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-08-29
 */
public class 动态规划_数位dp_记忆化搜索_q2719_统计整数数目 {

    @Test
    public void test() {
        System.out.println(count("4179205230"
                , "7748704426"
                , 8, 46));
    }

    private String max;
    private String min;
    private int minSum;
    private int maxSum;
    private Integer[][][][][] memo;
    private static final int MOD = (int) 1E9 + 7;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        StringBuilder stringBuilder = new StringBuilder(num1);
        while (stringBuilder.length() < num2.length()) {
            stringBuilder.insert(0, '0');
        }
        this.min = stringBuilder.toString();
        this.max = num2;
        this.minSum = min_sum;
        this.maxSum = max_sum;
        this.memo = new Integer[num2.length()][400][2][2][2];
        return dfs(0, 0, 1, 1, 0);
    }

    //可以优化 isNum可以直接挪掉 isUpLimit和downLimit可以直接合成一个？ 可以减少很多时间
    private int dfs(int index, int count, int isUpLimit, int isDownLimit, int isNum) {
        if (index == max.length()) {
            return (isNum == 1 && (count >= minSum && count <= maxSum)) ? 1 : 0;
        }
        if (count > maxSum) {
            return 0;
        }
        if (memo[index][count][isUpLimit][isDownLimit][isNum] != null) {
            return memo[index][count][isUpLimit][isDownLimit][isNum];
        }
        int up = isUpLimit == 1 ? max.charAt(index) - '0' : 9;
        int down = isDownLimit == 1 ? min.charAt(index) - '0' : 0;
        int res = 0;
        for (int i = down; i <= up; i++) {
            int isNextUpLimit = (isUpLimit == 1 && i == up) ? 1 : 0;
            int isNextDownLimit = (isDownLimit == 1 && i == down) ? 1 : 0;
            int isNextNum = isNum == 0 ? (i == 0 ? 0 : 1) : 1;
            res = (res + dfs(index + 1, count + i, isNextUpLimit, isNextDownLimit, isNextNum)) % MOD;
        }
        return memo[index][count][isUpLimit][isDownLimit][isNum] = res;
    }

}
