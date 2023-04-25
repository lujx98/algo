package com.lu.all;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sheldon
 * @date 2023-04-25
 */
public class 模拟_q2418_按身高排序 {

    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], i);
        }
        Arrays.sort(heights);
        String[] res = new String[names.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            res[heights.length - i - 1] = names[map.get(heights[i])];
        }
        return res;
    }

}
