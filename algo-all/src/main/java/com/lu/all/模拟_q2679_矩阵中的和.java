package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-04
 */
public class 模拟_q2679_矩阵中的和 {

    @Test
    public void test(){
        matrixSum(ArrayUtils.makeIntArraysByString("[[7,2,1],[6,4,2],[6,5,3],[3,2,1]]"));
    }

    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int sum = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int cur = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                cur = Math.max(cur, nums[j][i]);
            }
            sum += cur;
        }
        return sum;
    }

}
