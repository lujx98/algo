package com.lu.all;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-07-07
 */
public class 模拟_q219_存在重复元素II {

    @Test
    public void test() {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length && i < k; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            set.remove(nums[i - k]);
        }
        return false;
    }

}
