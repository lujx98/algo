package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-12-31
 */
public class 贪心_排序_q2037 {

    @Test
    public void test(){
        System.out.println(minMovesToSeat(new int[]{3,1,5}, new int[]{2,7,4}));
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(students[i]-seats[i]);
        }

        return res;
    }

}
