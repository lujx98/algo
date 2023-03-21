package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-02-16
 */
public class 模拟_q2341 {

    @Test
    public void test() throws Exception {
        boolean a = true;
        try {
            throw new Exception();
        }catch (Exception e){
            if (a){
                throw e;
            }
        }
        System.out.println("1");
    }

    public int[] numberOfPairs(int[] nums) {
        int[] ints = new int[101];
        int count = nums.length;
        int pairCount = 0;
        for (int num : nums) {
            if (ints[num] == 1) {
                ints[num] ^= 1;
                count -= 2;
                pairCount++;
            } else {
                ints[num]++;
            }
        }
        return new int[]{pairCount, count};
    }

}
