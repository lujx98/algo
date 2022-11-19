package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-11-16
 */
public class q775_0_rev {

    @Test
    public void test() {
        System.out.println(isIdealPermutation1(new int[]{1, 0, 2}));
    }

    public boolean isIdealPermutation1(int[] nums) {
        int length = nums.length;
        int minSuffix = nums[length - 1];
        for (int i = length - 3; i >= 0; i--) {
            if (nums[i] > minSuffix) {
                return false;
            }
            minSuffix = Math.min(minSuffix, nums[i + 1]);
        }
        return true;
    }

    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public boolean isIdealPermutation(int[] nums) {
        int sessionCount = 0;
        int globalCount = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    if (j == i + 1) {
                        globalCount++;
                        sessionCount++;
                    } else {
                        globalCount++;
                    }
                }
            }
        }
        return sessionCount == globalCount;
    }

}
