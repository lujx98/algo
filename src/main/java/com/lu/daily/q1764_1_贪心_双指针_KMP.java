package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-17
 */
public class q1764_1_贪心_双指针_KMP {

    @Test
    public void test(){

    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        for (int k = 0; i < groups.length && k < nums.length; ) {
            if (checkNum(nums, k, groups[i])) {
                k += groups[i].length;
                i++;
            } else {
                k++;
            }
        }
        return i == groups.length;
    }

    private boolean checkNum(int[] nums, int k, int[] group) {
        if (group.length > nums.length - k) {
            return false;
        }
        for (int j : group) {
            if (!(nums[k++] == j)) {
                return false;
            }
        }
        return true;
    }

}
