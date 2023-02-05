package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-02-05
 */
public class q1798_贪心_思考题_你能构造出连续值的最大数目 {

    @Test
    public void test() {
        System.out.println(getMaximumConsecutive(new int[]{1, 3}));
    }

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int count = 0;
        for (int coin : coins) {
            if (coin <= count + 1) {
                count += coin;
            }
        }
        return count + 1;
    }

}
