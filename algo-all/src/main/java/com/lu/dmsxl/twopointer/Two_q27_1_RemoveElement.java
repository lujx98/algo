package com.lu.dmsxl.twopointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-09-17
 */
public class Two_q27_1_RemoveElement {

    @Test
    public void test() {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int right = 0;
        int left = 0;
        for (; right < nums.length; right++) {
            if (!Objects.equals(nums[right], val)){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

//    public int removeElement(int[] nums, int val) {
//        int left = 0;
//        for (int right = 0; right < nums.length; right++) {
//            if (!Objects.equals(val, nums[right])) {
//                nums[left++] = nums[right];
//            }
//        }
//        return left;
//    }

}
