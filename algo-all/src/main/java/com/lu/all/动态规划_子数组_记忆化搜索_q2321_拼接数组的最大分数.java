package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-20
 */
public class 动态规划_子数组_记忆化搜索_q2321_拼接数组的最大分数 {

    private int[] nums2;
    private int[] nums1;
    private int[] memo1;
    private int[] memo2;

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.memo1 = new int[nums1.length];
        this.memo2 = new int[nums2.length];
        Arrays.fill(memo1,Integer.MIN_VALUE);
        Arrays.fill(memo2,Integer.MIN_VALUE);
        int res1 = Integer.MIN_VALUE;
        int res2 = Integer.MIN_VALUE;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        for (int i = 0; i < nums1.length; i++) {
            res1 = Math.max(dfs1(i), res1);
            res2 = Math.max(dfs2(i), res2);
        }
        if (res1 < 0 && res2 < 0) {
            return Math.max(sum1, sum2);
        }
        return Math.max(sum1 + res1, sum2 + res2);
    }

    private int dfs1(int i) {
        if (i < 0) {
            return 0;
        }
        if (memo1[i] != Integer.MIN_VALUE) {
            return memo1[i];
        }
        return memo1[i] = Math.max(nums2[i] - nums1[i], nums2[i] - nums1[i] + dfs1(i - 1));
    }

    private int dfs2(int i) {
        if (i < 0) {
            return 0;
        }
        if (memo2[i] != Integer.MIN_VALUE) {
            return memo2[i];
        }
        return memo2[i] = Math.max(nums1[i] - nums2[i], nums1[i] - nums2[i] + dfs2(i - 1));
    }

}
