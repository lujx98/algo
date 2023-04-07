package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-03-17
 */
public class rev_q2488 {

    public int countSubarrays(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                index = i;
                break;
            }
        }

        if (index == nums.length - 1) {
            return 0;
        }

        int right = nums.length - 1 - index;
        int left = index;



        return 0;
    }

}
