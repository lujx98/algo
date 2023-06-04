package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-04
 */
public class 模拟_q2465_不同的平均值数目 {

    public int distinctAverages(int[] nums) {
        boolean[] arr = new boolean[201];
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int i = nums[left] + nums[right];
            if (!arr[i]) {
                count++;
                arr[i] = true;
            }
            left++;
            right--;
        }
        return count;
    }

}
