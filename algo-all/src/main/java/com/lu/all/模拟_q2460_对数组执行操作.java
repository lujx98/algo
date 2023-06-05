package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-05
 */
public class 模拟_q2460_对数组执行操作 {

    @Test
    public void test() {
    }

    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0 && nums[i] == nums[i + 1]) {
                res[index++] = nums[i] * 2;
                i++;
            } else if (nums[i] != 0) {
                res[index++] = nums[i];
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            res[index++] = nums[nums.length - 1];
        }
        return res;
    }

}
