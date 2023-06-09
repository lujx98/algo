package com.lu.all;

import com.sun.scenario.effect.impl.state.AccessHelper;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-09
 */
public class rev_二分查找_q275_H指数II {

    @Test
    public void test() {
        System.out.println(hIndex(new int[]{1,2}));
    }

    public int hIndex(int[] citations) {
        if (citations[citations.length - 1] < 1) {
            return 0;
        }
        int right = citations.length, left = 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //mid 为 h 值： cit[length - h]>h
            if (check(mid, citations)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int mid, int[] citations) {
        return citations[citations.length - mid] > mid;
    }

}
