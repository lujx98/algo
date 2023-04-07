package com.lu.all;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-04-07
 */
public class 模拟_q剑指Offer03_数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> objects = new HashSet<>();
        for (int num : nums) {
            if (objects.contains(num)) {
                return num;
            }
            objects.add(num);
        }
        return -1;
    }

}
