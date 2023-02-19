package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-31
 */
public class q2319_模拟 {

    @Test
    public void test() {
        System.out.println(checkXMatrix(new int[][]{new int[]{2, 0, 0, 1}, new int[]{0, 3, 1, 0}, new int[]{0, 5, 2, 0}, new int[]{4, 0, 0, 2}}));
    }

    public boolean checkXMatrix(int[][] grid) {
        int up = 0;
        int down = grid.length - 1;
        for (int[] ints : grid) {
            for (int i = 0; i < ints.length; i++) {
                if (i == down || i == up) {
                    if (ints[i] == 0) {
                        return false;
                    }
                } else {
                    if (ints[i] != 0) {
                        return false;
                    }
                }
            }
            up++;
            down--;
        }
        return true;
    }

}
