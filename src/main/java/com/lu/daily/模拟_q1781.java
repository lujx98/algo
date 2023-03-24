package com.lu.daily;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sheldon
 * @date 2022-12-12
 */
public class 模拟_q1781 {

    public int beautySum(String s) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), 1);
            for (int j = i + 1; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                sum += getBeautySum(map.values());
            }
            map = new TreeMap<>();
        }
        return sum;
    }

    private int getBeautySum(Collection<Integer> values) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer value : values) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        return max - min;
    }

}
