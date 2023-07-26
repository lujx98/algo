package com.lu.all;

import org.checkerframework.checker.units.qual.min;
import org.junit.Test;

import java.lang.management.PlatformManagedObject;
import java.util.*;

/**
 * @author sheldon
 * @date 2023-05-14
 */
public class 贪心_堆_q1054_距离相等的条形码 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2})));
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes.length == 1) {
            return barcodes;
        }
        PriorityQueue<int[]> min = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            if (map.containsKey(barcode)) {
                map.put(barcode, map.get(barcode) + 1);
            } else {
                map.put(barcode, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            min.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int index = 0;
        while (!min.isEmpty()) {
            int[] poll = min.poll();
            if (index != 0 && barcodes[index - 1] == poll[0]) {
                int[] poll1 = min.poll();
                barcodes[index++] = poll1[0];
                if (poll1[1] > 1) {
                    poll1[1]--;
                    min.offer(poll1);
                }
                min.offer(poll);
            }else {
                barcodes[index++] = poll[0];
                if (poll[1] > 1) {
                    poll[1]--;
                    min.offer(poll);
                }
            }

        }
        return barcodes;
    }

}
