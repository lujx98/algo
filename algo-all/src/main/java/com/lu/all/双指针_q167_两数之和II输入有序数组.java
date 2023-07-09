package com.lu.all;

/**
 * @author sheldon
 * @date 2023-03-27
 */
public class 双指针_q167_两数之和II输入有序数组 {

    public int[] twoSum1(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int leftVal = numbers[left];
            while (leftVal + numbers[right] > target) {
                right--;
            }
            if (leftVal + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            left++;
        }
        return null;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 1, right = numbers.length;
        int sum = numbers[left - 1] + numbers[right - 1];
        while (sum != target) {
            if (sum > target) {
                right--;
            } else {
                left++;
            }
            sum = numbers[left - 1] + numbers[right - 1];
        }
        return new int[]{left, right};
    }

}
