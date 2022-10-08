package com.lu.dmsxl.uncatagorized;

import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-09-17
 */
public class q27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (!Objects.equals(val, nums[right])) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }

}
