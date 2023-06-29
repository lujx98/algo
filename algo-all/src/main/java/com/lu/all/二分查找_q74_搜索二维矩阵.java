package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-09
 */
public class 二分查找_q74_搜索二维矩阵 {

    @Test
    public void test() {
        System.out.println(searchMatrix(ArrayUtils.makeIntArraysByString("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix[mid], target)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for (int i : matrix[left]) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] matrix, int mid) {
        if (matrix[0] <= mid && matrix[matrix.length - 1] >= mid) {
            return false;
        } else if (matrix[0] > mid) {
            return false;
        } else {
            return true;
        }

    }

}
