package com.lu.ex;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-06
 */
public class q941_双指针_有效的山脉数组 {

    @Test
    public void test() {
        System.out.println(validMountainArray(new int[]{2, 1}));
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int left = arr.length - 1;
        int right = 0;
        while (left != 0 && arr[left] < arr[left - 1]) {
            left--;
        }
        while (right != arr.length - 1 && arr[right] < arr[right + 1]) {
            right++;
        }
        return left == right && left != arr.length - 1 && right != 0;
    }

}
