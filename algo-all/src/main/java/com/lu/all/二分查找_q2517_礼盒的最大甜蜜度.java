package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-01
 */
public class 二分查找_q2517_礼盒的最大甜蜜度 {

    @Test
    public void test() {
        System.out.println(maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        //枚举查找绝对差的最小值
        int left = 0;
        int right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(price, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] price, int k, int mid) {
        for (int left = 0, right = 0; left < price.length; right++) {
            if (k == 0) {
                break;
            }
            while (right < price.length && price[right] - price[left] < mid) {
                right++;
            }
            k--;
            left = right;
        }
        return k == 0;
    }

}
