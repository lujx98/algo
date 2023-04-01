package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class DP_43_q718_0_FindLength {

    @Test
    public void test() {
        System.out.println(findLength1(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    public int findLength3(int[] nums1, int[] nums2) {
        //dp[i][j] 表示到nums[i] nums[j]为止，之前最大公共序列长度
        //dp[i][j] = 0 如果nums1[i] nums2[j]不等
        //dp[i][j] = max(dp[i][j],dp[i-1][j-1]+1) 如果nums1[i] nums2[j]等
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    if ((dp[i][j] = dp[i - 1][j - 1] + 1) > res) {
                        res = dp[i][j];
                    }
                }
            }
        }
        return res;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            int pre = dp[0];
            for (int j = 1; j <= nums2.length; j++) {
                int cur = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    if ((dp[j] = pre + 1) > res) {
                        res = dp[j];
                    }
                } else {
                    dp[j] = 0;
                }
                pre = cur;
            }
        }
        return res;
    }

    public int findLength1(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    if ((dp[i][j] = dp[i - 1][j - 1] + 1) > res) {
                        res = dp[i][j];
                    }
                }
            }
        }
        return res;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > result) {
                        result = dp[i][j];
                    }
                }
            }
        }
        return result;
    }

}
