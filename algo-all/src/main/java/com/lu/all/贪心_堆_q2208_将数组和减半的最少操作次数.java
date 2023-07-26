package com.lu.all;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sheldon
 * @date 2023-07-26
 */
public class 贪心_堆_q2208_将数组和减半的最少操作次数 {

    @Test
    public void test() {
        System.out.println(halveArray(new int[]{5, 19, 8, 1}));
    }

    public int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return - o1.compareTo(o2);
            }
        });
        double sum = 0;
        for (int num : nums) {
            sum += num;
            queue.offer((double) num);
        }
        double sum1 = sum;
        int count = 0;
        while (sum1 > sum / 2) {
            double poll = queue.poll() / 2.0;
            queue.offer(poll);
            sum1 -= poll;
            count++;
        }
        return count;
    }

}
