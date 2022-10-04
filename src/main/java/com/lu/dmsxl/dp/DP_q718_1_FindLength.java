package com.lu.dmsxl.dp;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class DP_q718_1_FindLength {

    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        Arrays.fill(dp[0], 0);
        for (int[] ints : dp) {
            ints[0] = 0;
        }
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
