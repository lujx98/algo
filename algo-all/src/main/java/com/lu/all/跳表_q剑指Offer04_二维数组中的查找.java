package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-07
 */
public class 跳表_q剑指Offer04_二维数组中的查找 {

    @Test
    public void test() {
        System.out.println(findNumberIn2DArray(new int[][]{new int[]{5}, new int[]{6}}, 6));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int index = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (; index >= 0; index--) {
                if (matrix[i][index] == target) {
                    return true;
                }
                if (matrix[i][index] < target) {
                    break;
                }
            }
        }
        return false;
    }

}
