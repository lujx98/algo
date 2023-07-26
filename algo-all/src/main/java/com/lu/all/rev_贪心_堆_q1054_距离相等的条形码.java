package com.lu.all;

import org.checkerframework.checker.units.qual.min;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sheldon
 * @date 2023-05-14
 */
public class rev_贪心_堆_q1054_距离相等的条形码 {

    @Test
    public void test() {
        System.out.println(rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2}));
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes.length == 1) {
            return barcodes;
        }
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int barcode : barcodes) {
            min.offer(barcode);
            max.offer(barcode);
        }
        for (int i = 0; i < barcodes.length / 2; i++) {
            barcodes[2 * i] = min.poll();
            barcodes[2 * i + 1] = max.poll();
        }
        if (barcodes.length % 2 == 1) {
            barcodes[barcodes.length - 1] = min.poll();
        }
        return barcodes;
    }

}
