package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author sheldon
 * @date 2023-10-14
 */
public class 排序树_模拟_q1488_避免洪水泛滥 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(avoidFlood(new int[]{0, 1, 1})));
    }

    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                set.add(i);
            }
        }
        int[] res = new int[rains.length];
        HashMap<Integer, Integer> objects = new HashMap<>();
        for (int i = rains.length - 1; i >= 0; i--) {
            if (objects.containsKey(rains[i])) {
                Integer nextRainDay = objects.get(rains[i]);
                Integer prevDrain = set.lower(nextRainDay);
                if (prevDrain == null || prevDrain < i) {
                    return new int[]{};
                }
                set.remove(prevDrain);
                res[prevDrain] = rains[i];
            }
            if (rains[i] != 0) {
                objects.put(rains[i], i);
            }
        }


        for (Integer integer : set) {
            res[integer] = 1;
        }

        for (int i = 0; i < res.length; i++) {
            if (rains[i] > 0) {
                res[i] = -1;
            }
        }

        return res;
    }

}
