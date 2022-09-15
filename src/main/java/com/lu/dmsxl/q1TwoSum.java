package com.lu.dmsxl;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-09-15
 */
public class q1TwoSum {

    @Test
    public void test(){
        twoSum(new int[]{3,2,4},6);
    }

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int firstIndex = 0;
        int secIndex = nums.length - 1;
        int sum;
        while ((sum = nums[firstIndex] + nums[secIndex]) != target) {
            if (sum > target) {
                secIndex--;
            } else {
                firstIndex++;
            }
        }
        return new int[]{firstIndex,secIndex};
    }

}
