package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-27
 */
public class 模拟_q2500_删除每行中的最大值 {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int res = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(grid[i][j], max);
            }
            res += max;
        }
        return res;
    }

}
