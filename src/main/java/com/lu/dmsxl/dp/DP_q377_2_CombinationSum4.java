package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-30
 */
public class DP_q377_2_CombinationSum4 {

    @Test
    public void test(){
        System.out.println(combinationSum4(new int[]{1,2,3},4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] ints = new int[target + 1];
        ints[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    ints[i] += ints[i - nums[j]];
                }
            }
        }
        return ints[target];
    }

}
