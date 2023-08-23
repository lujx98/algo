package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-09
 */
public class 二分查找_q275_H指数II {

    @Test
    public void test() {
        System.out.println(hIndex(new int[]{0}));
    }

    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(citations, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] citations, int mid) {
        if (mid == 0) {
            return citations[citations.length - 1] == 0;
        }
        return citations[citations.length - mid] >= mid;
    }

}
