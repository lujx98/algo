package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sheldon
 * @date 2023-06-06
 */
public class 模拟_q2352_相等行列对 {

    @Test
    public void test() {
        System.out.println(equalPairs(ArrayUtils.makeIntArraysByString("[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]")));
    }

    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> objects = new HashMap();
        for (int[] ints : grid) {
            List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
            Integer integer = objects.get(collect);
            if (integer != null) {
                objects.put(collect, integer + 1);
            } else {
                objects.put(collect, 1);
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int[] ints : grid) {
                list.add(ints[i]);
            }
            Integer integer = objects.get(list);
            if (integer != null) {
                res += integer;
            }
        }
        return res;
    }

}
