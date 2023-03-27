package com.lu.daily;

/**
 * @author sheldon
 * @date 2023-03-27
 */
public class 双指针_q167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 1, right = numbers.length;
        int sum = numbers[left-1] + numbers[right-1];
        while (sum != target) {
            if (sum > target) {
                right--;
            }else {
                left++;
            }
            sum = numbers[left-1] + numbers[right-1];
        }
        return new int[]{left, right};
    }

}
