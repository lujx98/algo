package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-09-18
 */
public class 二分查找_最大最小值_q2064_分配给商店的最多商品的最小值 {

    @Test
    public void test() {
        System.out.println(minimizedMaximum(6, new int[]{11, 6}));
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 0, right = Arrays.stream(quantities).max().getAsInt();
        Arrays.sort(quantities);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, n, quantities)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int mid, int n, int[] quantities) {
        if (mid == 0) {
            return false;
        }
        for (int quantity : quantities) {
            if (n <= 0) {
                return false;
            }
            if (quantity <= mid) {
                n--;
            } else {
                n -= ((quantity + mid - 1) / mid);
            }
        }
        return n >= 0;
    }

}
