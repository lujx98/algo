package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-26
 */
public class 二分查找_q2485_找出中枢整数 {

    @Test
    public void test() {
        System.out.println(pivotInteger(8));
    }

    public int pivotInteger(int n) {
        int all = n * (n + 1) / 2;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int leftSum = (mid + 1) * mid / 2;
            int rightSum = all - leftSum + mid;
            if (rightSum > leftSum) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left + 1) * left / 2 == all - ((left + 1) * left / 2) + left ? left : -1;
    }

}
