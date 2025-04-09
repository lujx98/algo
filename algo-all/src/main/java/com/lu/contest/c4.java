package com.lu.contest;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class c4 {

    @Test
    public void test() {
        System.out.println(constructProductMatrix(ArrayUtils.makeIntArraysByString("[[12345],[2],[1]]")));
    }

    public int[][] constructProductMatrix(int[][] grid) {
        BigDecimal bigDecimal = new BigDecimal(1);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                bigDecimal = bigDecimal.multiply(new BigDecimal(grid[i][j]));
            }
        }
        int[][] ints = new int[grid.length][grid[0].length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                ints[i][j] = bigDecimal.divide(new BigDecimal(grid[i][j])).divideAndRemainder(new BigDecimal(12345))[1].intValue();
            }
        }
        return ints;
    }

}
