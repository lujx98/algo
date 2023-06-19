package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-14
 */
public class rev_q31 {

    @Test
    public void test(){
        nextPermutation(new int[]{1,2,3});
    }

    public void nextPermutation(int[] nums) {
        int big = nums.length - 1, cur = nums.length - 1;
        for (; big > 0; big--) {
            for (; cur >= 0; cur--) {
                if (nums[cur] < nums[big]) {
                    int temp = nums[cur];
                    nums[cur] = nums[big];
                    nums[big] = temp;
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

}
