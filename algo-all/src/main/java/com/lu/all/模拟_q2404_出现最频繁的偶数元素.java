package com.lu.all;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sheldon
 * @date 2023-04-13
 */
public class 模拟_q2404_出现最频繁的偶数元素 {

    @Test
    public void test() {
        System.out.println(mostFrequentEven(new int[]{0, 1, 2, 0, 0, 0, 2, 4, 4, 1}));
    }

    public int mostFrequentEven(int[] nums) {
        int res = -1;
        int resCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if ((num & 1) == 1) {
                continue;
            }
            if (res == -1) {
                res = num;
                resCount = 1;
                map.put(num, 1);
                continue;
            }
            if (num == res) {
                resCount++;
            }
            Integer integer = map.get(num);
            int count = integer == null ? 1 : integer + 1;
            if (count == resCount && res > num) {
                res = num;
            } else if (count > resCount) {
                res = num;
                resCount = count;
            }
            map.put(num, count);
        }
        return res;
    }

}
