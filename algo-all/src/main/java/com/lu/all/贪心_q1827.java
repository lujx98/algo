package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-11
 */
public class 贪心_q1827 {

    @Test
    public void test() {
        System.out.println(minOperations(new int[]{1, 1, 1}));
    }

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }

}
