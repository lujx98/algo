package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-05-14
 */
public class 模拟_q6367_矩阵中的和 {

    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int point = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int max = 0;
            for (int[] num : nums) {
                max = Math.max(num[i], max);
            }
            point += max;
        }
        return point;
    }

}
