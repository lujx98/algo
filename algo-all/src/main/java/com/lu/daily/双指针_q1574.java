package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-25
 */
public class 双指针_q1574 {

    @Test
    public void test() {
        System.out.println(findLengthOfShortestSubarray1(new int[]{16,10,0,3,22,1,14,7,1,12,15}));
    }

    //https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/solutions/2189149/dong-hua-yi-xie-jiu-cuo-liang-chong-xie-iijwz/
    public int findLengthOfShortestSubarray(int[] arr) {
        int rightIndex = arr.length - 1;
        while (rightIndex > 0) {
            if (arr[rightIndex] - arr[rightIndex - 1] < 0) {
                break;
            }
            rightIndex--;
        }
        if (rightIndex == 0) {
            return 0;
        }

        int ans = arr.length - 1;
        for (int i = 0; i < rightIndex; i++) {
            if (i != 0 && arr[i] - arr[i - 1] < 0) {
                break;
            }
            while (rightIndex <= arr.length - 1 && arr[rightIndex] - arr[i] < 0) {
                rightIndex++;
            }
            ans = Math.min(ans, (rightIndex - i - 1));
        }
        return ans;
    }

    public int findLengthOfShortestSubarray1(int[] arr) {
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right])
            --right;
        if (right == 0) return 0; // arr 已经是非递减数组
        // 此时 arr[right-1] > arr[right]
        int ans = right; // 删除 0 到 right-1
        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; ++left) {
            while (right < n && arr[right] < arr[left])
                ++right;
            // 此时 arr[left] <= arr[right]，从 left+1 到 right-1 可以删除
            ans = Math.min(ans, right - left - 1);
        }
        return ans;
    }

}
