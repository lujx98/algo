package com.lu.all;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sheldon
 * @date 2023-07-08
 */
public class 模拟_q6469_重新放置石块 {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < moveFrom.length; i++) {
            collect.remove(moveFrom[i]);
            collect.add(moveTo[i]);
        }
        return collect.stream().sorted().collect(Collectors.toList());
    }

}
