package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-01-07
 */
public class 滑动窗口_双指针_q1658 {

    @Test
    public void test(){
        System.out.println(minOperations(new int[]{1,1,4,2,3}, 5));
    }

    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        if (sum < x) {
            return -1;
        }
        int leftSum = 0, rightSum = sum;
        int left = -1, right = 0;
        int length = nums.length;
        int res = length;
        boolean found = false;

        for (; left < length; left++) {
            leftSum += left == -1 ? 0 : nums[left];
            while (right < length && leftSum + rightSum > x) {
                rightSum -= nums[right];
                right++;
            }
            if (leftSum + rightSum == x) {
                found = true;
                res = Math.min(res, left + 1 + (length - right));
            }
        }

        return found ? res : -1;
    }

}
