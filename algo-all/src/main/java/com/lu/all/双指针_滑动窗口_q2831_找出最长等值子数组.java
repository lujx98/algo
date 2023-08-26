package com.lu.all;

import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-08-20
 */
public class 双指针_滑动窗口_q2831_找出最长等值子数组 {

    @Test
    public void test() {
        System.out.println(longestEqualSubarray(Arrays.asList(2, 1), 1));
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer key = nums.get(i);
            if (map.containsKey(key)) {
                map.get(key).add(i);
            } else {
                map.put(key, new ArrayList<>(Collections.singletonList(i)));
            }
        }
        int res = 1;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            List<Integer> value = integerListEntry.getValue();
            int count = 0;
            int left = 0;
            for (int right = 1; right < value.size(); right++) {
                count += value.get(right) - value.get(right - 1) - 1;
                while (count > k) {
                    left++;
                    count -= value.get(left) - value.get(left - 1) - 1;
                }
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }

}
