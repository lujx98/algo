package com.lu.ex;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-06
 */
public class q283_双指针_移动零 {

    @Test
    public void test(){
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
