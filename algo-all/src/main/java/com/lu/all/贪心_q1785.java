package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-17
 */
public class 贪心_q1785 {

    @Test
    public void test(){
        System.out.println(minElements(new int[]{1, -1, 1}, 3, -4));
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long targetNum = Math.abs(goal - sum);
        return (int)((targetNum + limit - 1) / limit);
    }

}
