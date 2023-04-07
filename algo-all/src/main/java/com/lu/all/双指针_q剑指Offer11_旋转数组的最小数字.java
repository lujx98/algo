package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-07
 */
public class 双指针_q剑指Offer11_旋转数组的最小数字 {

    @Test
    public void test() {
//        System.out.println(minArray(new int[]{3, 4, 5, 1, 2}));
//        System.out.println(minArray(new int[]{2,2,2,0,1}));
        System.out.println(minArray(new int[]{1, 3, 5}));
    }

    public int minArray(int[] numbers) {
        int right = numbers.length - 1, left = 0;
        while (right > left) {
            if (numbers[right] < numbers[right - 1]) {
                return numbers[right];
            }
            if (numbers[left] > numbers[left + 1]) {
                return numbers[left + 1];
            }
            right--;
            left++;
        }
        return numbers[0];
    }

}
