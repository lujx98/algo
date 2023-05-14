package com.lu.all;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sheldon
 * @date 2023-05-13
 */
public class rev_q2441 {

    public int findMaxK(int[] nums) {
        Set<Integer> map = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            if (map.contains(-num)) {
                res = Math.max(Math.abs(num), res);
            }
            map.add(num);
        }
        return res;
    }

}
