package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-04
 */
public class 模拟_q6424_半有序排列 {

    @Test
    public void test() {
        System.out.println(semiOrderedPermutation(new int[]{2, 1, 4, 3}));
    }

    public int semiOrderedPermutation(int[] nums) {
        int length = nums.length;
        boolean isLengthBeforeZero = false;
        int oneIndex = -1;
        int lengthIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                oneIndex = i;
            }
            if (nums[i] == length) {
                lengthIndex = i;
                if (oneIndex == -1) {
                    isLengthBeforeZero = true;
                }
            }
        }
        int res = (oneIndex) + (length - 1 - lengthIndex);
        return isLengthBeforeZero ? res - 1 : res;
    }

}
