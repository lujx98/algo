package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author sheldon
 * @date 2023-06-13
 */
public class rev_q2475 {

    @Test
    public void test() {
        System.out.println(unequalTriplets(new int[]{1, 3, 1, 2, 4}));
    }

    public int unequalTriplets(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        if (map.size() < 3) {
            return 0;
        }
        int res = 1;
        for (Integer value : map.values()) {
            res *= value;
        }
        return res;
    }

}
