package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-09
 */
public class 动态规划_子数组_状态机dp_记忆化搜索_q6912_构造最长非递减子数组 {

    @Test
    public void test() {
        System.out.println(maxNonDecreasingLength(new int[]{11, 7, 7, 9}, new int[]{19, 19, 1, 7}));
    }

    private int[] nums1;
    private int[] nums2;
    private int[][] memo;

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.memo = new int[nums1.length][2];
        for (int[] ints : this.memo) {
            Arrays.fill(ints, -1);
        }
        int ans = 1;
        for (int i = 0; i < nums1.length; i++) {
            ans = Math.max(ans, Math.max(dfs(i, 1), dfs(i, 2)));
        }
        return ans;
    }

    private int dfs(int i, int which) {
        if (memo[i][which - 1] != -1) {
            return memo[i][which - 1];
        }
        if (i == nums1.length - 1) {
            return 1;
        }

        int prev;
        if (which == 1) {
            prev = nums1[i];
        } else {
            prev = nums2[i];
        }

        int dfs = Integer.MIN_VALUE;
        if (nums1[i + 1] >= prev) {
            dfs = Math.max(dfs, dfs(i + 1, 1) + 1);
        }
        if (nums2[i + 1] >= prev) {
            dfs = Math.max(dfs, dfs(i + 1, 2) + 1);
        }
        if (dfs == Integer.MIN_VALUE) {
            dfs = 1;
        }

        return memo[i][which - 1] = dfs;
    }

}
