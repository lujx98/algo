package com.lu.all;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author sheldon
 * @date 2023-09-03
 */
public class 前缀和_q525_连续数组 {

    @Test
    public void test() {
        System.out.println(findMaxLength(new int[]{1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1}));
    }

    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefix.length; i++) {
            map.putIfAbsent(prefix[i], i);
        }
        int res = 0;
        for (int i = prefix.length - 1; i > 0; i--) {
            if (prefix[i] == 0) {
                res = Math.max(res, i);
            }
            if (map.containsKey(prefix[i])) {
                res = Math.max(res, i - map.get(prefix[i]));
            }
        }
        return res;
    }

}
