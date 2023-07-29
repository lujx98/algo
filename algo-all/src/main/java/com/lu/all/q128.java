package com.lu.all;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2023-07-19
 */
public class q128 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> prevMap = new HashMap<>();
        int res = 1;
        for (int num : nums) {
            Integer m1 = prevMap.get(num - 1);
            Integer p1 = prevMap.get(num + 1);
            if (m1 != null || p1 != null) {
                int cur = Math.max(m1==null?0:m1,p1==null?0:p1);
                Math.max(cur+1,res);

            } else {
                prevMap.put(num, 1);
            }
        }
        return res;
    }

}
