package com.lu.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sheldon
 * @date 2023-02-24
 */
public class rev_q2357 {

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            set.add(num);
        }
        return set.size();
    }

}
