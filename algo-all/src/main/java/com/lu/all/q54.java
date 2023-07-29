package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-07-19
 */
public class q54 {

    @Test
    public void test() {
        System.out.println(spiralOrder(ArrayUtils.makeIntArraysByString("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]")));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int offset = 0;
        List<Integer> res = new ArrayList<>();
        int threshold = Math.min(matrix.length, matrix[0].length) / 2;
        while (true) {
            if (offset > threshold) {
                return res;
            }
            for (int i = 0; i < matrix[offset].length; i++) {
                if (i < offset || i > matrix[0].length - 1 - offset) {
                    continue;
                }
                res.add(matrix[offset][i]);
            }
            if (matrix.length % 2 == 1 && offset == threshold) {
                return res;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                if (i <= offset || i >= matrix.length - 1 - offset) {
                    continue;
                }
                res.add(matrix[i][matrix[0].length - 1 - offset]);
            }
            for (int i = matrix[matrix.length - 1 - offset].length - 1; i >= 0; i--) {
                if (i < offset || i > matrix[0].length - 1 - offset) {
                    continue;
                }
                res.add(matrix[matrix.length - 1 - offset][i]);
            }
            for (int i = matrix[0].length - 1; i >= 0; i--) {
                if (i <= offset || i >= matrix.length - 1 - offset) {
                    continue;
                }
                res.add(matrix[i][offset]);
            }
            offset++;
        }
    }

}
