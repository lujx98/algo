package com.lu.daily;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author sheldon
 * @date 2023-02-19
 */
public class q1792_优先队列_数学 {

    @Test
    public void test() {
        maxAverageRatio(new int[][]{new int[]{1, 2}, new int[]{3, 5}, new int[]{2, 2}}, 2);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<int[]> pq = new PriorityQueue<int[]>((v1, v2) -> (int) (math(v1, v2) - math(v2, v1)));
        for (int[] c : classes) {
            pq.offer(new int[]{c[0], c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }

        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / classes.length;
    }

    public double math(int[] v1, int[] v2) {
        return v1[1] * v2[1] * v2[1] - v1[0] * v2[1] * (v2[1] + 1);
    }

}
