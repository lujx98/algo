package com.lu.all;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * @author sheldon
 * @date 2023-08-08
 */
public class 前缀和_子数组_q1749_任意子数组和的绝对值的最大值 {

    public int maxAbsoluteSum(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int max  = Arrays.stream(prefix).max().getAsInt();
        int min  = Arrays.stream(prefix).min().getAsInt();
        return Math.abs(max - min);
    }

}
