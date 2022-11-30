package com.lu.daily;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/soup-servings/description/
 * <p>
 * 有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
 * <p>
 * 提供 100ml 的 汤A 和 0ml 的 汤B 。
 * 提供 75ml 的 汤A 和 25ml 的 汤B 。
 * 提供 50ml 的 汤A 和 50ml 的 汤B 。
 * 提供 25ml 的 汤A 和 75ml 的 汤B 。
 * 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
 * <p>
 * 注意 不存在先分配 100 ml 汤B 的操作。
 * <p>
 * 需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 50
 * 输出: 0.62500
 * 解释:如果我们选择前两个操作，A 首先将变为空。
 * 对于第三个操作，A 和 B 会同时变为空。
 * 对于第四个操作，B 首先将变为空。
 * 所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
 * 示例 2:
 * <p>
 * 输入: n = 100
 * 输出: 0.71875
 *
 * @author sheldon
 * @date 2022-11-21
 */
public class q808_1 {

    @Test
    public void test() {
        System.out.println(soupServingsB(100));
    }


    public double soupServingsB(int n) {
        int m = (int) Math.ceil((double) n / 25);
        if (m >= 179) {
            return 1.0;
        }
        //dp[i][j]表示 汤剩余量时i,j 对答案的贡献值
        //dp[i][j] = 0.25*dp[i+4][j] + 0.25*dp[i+3][j+1] ...
        double[][] dp = new double[m][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1.0;
        }
        dp[0][0] = 0.5D;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = (dp[Math.max(i - 4, 0)][j] + dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)]
                        + dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)]) / 4.0;
            }
        }

        return dp[m-1][m-1];
    }

    public double soupServings(int n) {
        int m = (int) Math.ceil((double) n / 25);
        if (m >= 179) {
            return 1.0;
        }
        //dp[i][j] i为汤a剩余量  j为汤b剩余量  i=0时表示汤a分完了  j=0时表示汤b分完了  i=0 j=0表示同时分完
        //i == 0 && j！= 0  这时候概率贡献为 0.5 * p(i = 0 && j！= 0)
        //i == 0 && j == 0  这时候概率贡献为 1 * p(i = 0 && j == 0)
        //也就是求概率期望  dp[n][n]表示汤没分的时候的概率期望  也即答案
        double[][] dp = new double[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1.0D;
        }
        dp[0][0] = 0.5D;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[Math.max(i - 4, 0)][j] + dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)]
                        + dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)]) / 4.0;
            }
        }
        return dp[m][m];
    }


}
