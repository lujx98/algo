package com.lu.all;

import org.junit.Test;

import java.util.Map;

/**
 * @author sheldon
 * @date 2023-06-14
 */
public class 模拟_q1375_二进制字符串前缀一致的次数 {

    @Test
    public void test(){
        System.out.println(numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
    }

    public int numTimesAllBlue(int[] flips) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < flips.length; i++) {
            int flip = flips[i];
            max = Math.max(max, flip);
            if (max == i + 1) {
                count++;
            }
        }
        return count;
    }

}
