package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-08-07
 */
public class 差分数组_q2772_使数组中的所有元素都等于零 {

    @Test
    public void test() {
        System.out.println(checkArray(new int[]{1, 2, 2, 1}, 3));
    }

    public boolean checkArray(int[] nums, int k) {
        int[] diff = new int[nums.length + 1];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (diff[i] == 0) {
                continue;
            }
            if (i + k > nums.length || diff[i] < 0) {
                return false;
            }
            diff[i + k] += diff[i];
            diff[i] -= diff[i];
        }
        return true;
    }

}
