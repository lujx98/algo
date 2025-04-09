package com.lu.all;

import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-09-05
 */
public class Aq1655 {

    @Test
    public void test() {
        int min = 43;
        int hrs = 2;
        for (int i = 0; i < 10; i++) {
            Date date = new Date(2024, 6, 23, hrs, min, 56);
            System.out.println(date);
            min = (min + 20) % 60;
            hrs = (hrs + 8) % 24;
        }
    }

    public boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            countMap.merge(entry.getValue(), 1, Integer::sum);
        }
        List<Integer> tmp = new ArrayList<>();
        for (int i : quantity) {
            if (countMap.containsKey(i)) {
                countMap.merge(i, -1, Integer::sum);
                if (countMap.get(i) == 0) {
                    countMap.remove(i);
                }
            } else {
                tmp.add(i);
            }
        }
        if (tmp.isEmpty()) {
            return true;
        }
        List<Integer> objects = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            for (Integer integer = 0; integer < entry.getValue(); integer++) {
                objects.add(entry.getKey());
            }
        }

        return dfs(0, tmp, objects);
    }

    private boolean dfs(int index, List<Integer> quantity, List<Integer> counts) {
        if (index == quantity.size()) {
            return true;
        }
        boolean res = false;
        for (int i = 0; i < counts.size(); i++) {
            Integer curCount = counts.get(i);
            if (curCount >= quantity.get(index)) {
                counts.set(i, curCount - quantity.get(index));
                res = res || dfs(index + 1, quantity, counts);
                counts.set(i, curCount);
            }
        }
        return res;
    }

}
