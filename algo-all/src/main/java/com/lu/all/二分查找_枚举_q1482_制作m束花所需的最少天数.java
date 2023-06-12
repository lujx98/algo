package com.lu.all;

import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-09
 */
public class 二分查找_枚举_q1482_制作m束花所需的最少天数 {


    @Test
    public void test() {
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int left = 0, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(mid, bloomDay, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return canMake(left, bloomDay, m, k) ? left : -1;
    }

    private boolean canMake(int mid, int[] bloomDay, int m, int k) {
        int cur = k;
        for (int i : bloomDay) {
            if (i <= mid) {
                cur--;
                if (cur == 0) {
                    m--;
                    cur = k;
                }
            } else {
                cur = k;
            }
        }
        return m <= 0;
    }

}
