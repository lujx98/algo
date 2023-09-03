package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-09-03
 */
public class 模拟_q1921_消灭怪物的最大数量 {

    @Test
    public void test() {
        System.out.println(eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        for (int i = 0; i < dist.length; i++) {
            dist[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        Arrays.sort(dist);
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < i + 1) {
                return i;
            }
        }
        return dist.length;
    }

}
