package com.lu.contest;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class c1 {

    @Test
    public void test() {
        System.out.println();
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};

    }
}

