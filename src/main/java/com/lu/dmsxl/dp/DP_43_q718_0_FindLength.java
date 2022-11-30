package com.lu.dmsxl.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class DP_43_q718_0_FindLength {

    @Test
    public void test() {
        System.out.println(findLength2(new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 1, 1}));
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
