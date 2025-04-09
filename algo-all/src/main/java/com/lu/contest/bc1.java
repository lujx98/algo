package com.lu.contest;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-08-27
 */
public class bc1 {

    @Test
    public void test() {
        System.out.println();
    }

    public int sumCounts(List<Integer> nums) {
        int res = 0;

        for (int i = 1; i <= nums.size(); i++) {
            int left = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < i; j++) {
                map.merge(nums.get(j), 1, Integer::sum);
            }
            while (left < i) {
                res += (map.size() * map.size());
                map.merge(nums.get(left), -1, Integer::sum);
                if (map.get(nums.get(left)) == 0) {
                    map.remove(nums.get(left));
                }
                left++;
            }
        }
        return res;
    }

}
