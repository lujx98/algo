package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-16
 */
public class 双指针_排序_q2779_数组的最大美丽值 {

    @Test
    public void test() {
        System.out.println(maximumBeauty(new int[]{4, 6, 1, 2}, 2));
    }

    public int maximumBeauty(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int res = 1;
        int left = 0, right = 0;
        int count = 0;
        while (right < counts.length && right < 2 * k + 1) {
            count += counts[right];
            right += 1;
        }
        right--;
        res = Math.max(res, count);
        for (; right < counts.length - 1; ) {
            count -= counts[left++];
            count += counts[++right];
            res = Math.max(res, count);
        }

        return res;
    }

}
