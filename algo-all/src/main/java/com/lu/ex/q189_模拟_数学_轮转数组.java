package com.lu.ex;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-06
 */
public class q189_模拟_数学_轮转数组 {

    @Test
    public void test() {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

}
