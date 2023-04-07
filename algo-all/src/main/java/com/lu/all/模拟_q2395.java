package com.lu.all;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author sheldon
 * @date 2023-03-26
 */
public class 模拟_q2395 {

    @Test
    public void test() {
        System.out.println(findSubarrays(new int[]{1, 2, 3, 4, 5}));
    }

    public boolean findSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i] + nums[i - 1], i);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            Integer integer = map.get(nums[i] + nums[i + 1]);
            if (integer != null && !Objects.equals(integer, i+1)) {
                return true;
            }
        }
        return false;
    }

}
