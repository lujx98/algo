package com.lu.all;

/**
 * @author sheldon
 * @date 2023-07-16
 */
public class 模拟_q2778_特殊元素平方和 {

    public int sumOfSquares(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length % i == 0) {
                res += nums[i] * nums[i];
            }
        }
        return res;
    }

}
