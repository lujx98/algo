package com.lu.all;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @author sheldon
 * @date 2023-10-22
 */
public class Aq_元素和最小的山形三元组II {

    @Test
    public void test() {
        System.out.println(minimumSum(new int[]{1, 1, 2, 1}));
    }

    public int minimumSum(int[] nums) {
        TreeMap<Integer, Integer> right = new TreeMap<>();
        TreeMap<Integer, Integer> left = new TreeMap<>();

        for (int i = 1; i < nums.length; i++) {
            right.merge(nums[i], 1, Integer::sum);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if ((!left.isEmpty() && left.firstKey() < nums[i])
                    && (!right.isEmpty() && right.firstKey() < nums[i])) {
                res = Math.min(res, nums[i] + left.firstKey() + right.firstKey());
            }
            left.merge(nums[i], 1, Integer::sum);
            if (i < nums.length - 1) {
                right.merge(nums[i + 1], -1, Integer::sum);
                if (right.get(nums[i + 1]) == 0) {
                    right.remove(nums[i + 1]);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
