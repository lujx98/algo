package com.lu.ex;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author sheldon
 * @date 2023-02-06
 */
public class q1365_模拟_有多少小于当前数字的数字 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], i);
        }
        for (int i = 0; i < ints.length; i++) {
            ints[i] = map.get(ints[i]);
        }
        return ints;
    }

}
