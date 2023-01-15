package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-15
 */
public class q2293_1_模拟 {

    @Test
    public void test() {
        System.out.println(minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
    }

    public int minMaxGame(int[] nums) {
        int len = nums.length;
        while (len != 1) {
            len /= 2;
            int index = 0;
            while (index != len) {
                if (index % 2 == 1) {
                    nums[index] = Math.max(nums[2 * index], nums[2 * index + 1]);
                } else {
                    nums[index] = Math.min(nums[2 * index], nums[2 * index + 1]);
                }
                index++;
            }
        }
        return nums[0];
    }

}
