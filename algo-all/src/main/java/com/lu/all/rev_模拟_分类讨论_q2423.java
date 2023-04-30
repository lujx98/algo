package com.lu.all;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sheldon
 * @date 2023-04-29
 */
public class rev_模拟_分类讨论_q2423 {

    public boolean equalFrequency(String word) {
        int[] counts = new int[26];
        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : counts) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        if (entries.size() != 2) {
            return false;
        }
        boolean second = false;
        int number = 0;
        int count = 0;
        //key为字母出现的次数  value为字母出现次数的个数
        //true:
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (!second) {
                count = entry.getValue();
                number = entry.getKey();
                second = true;
            } else {
                if (count != 1 && entry.getValue() != 1) {
                    return false;
                }
            }
        }
        return false;
    }

}
