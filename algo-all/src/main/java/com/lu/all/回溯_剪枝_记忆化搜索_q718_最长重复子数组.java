package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-10-04
 */
public class 回溯_剪枝_记忆化搜索_q718_最长重复子数组 {

    @Test
    public void test() {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    private int[] nums2;
    private int[] nums1;
    private boolean[][] memo;

    public int findLength(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.memo = new boolean[nums1.length][nums2.length];
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (!memo[i][j]) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int index1, int index2) {
        if (nums1[index1] != nums2[index2]) {
            return 0;
        }
        int ans = 0;
        while (index1 < nums1.length
                && index2 < nums2.length
                && nums1[index1] == nums2[index2]) {
            memo[index1][index2] = true;
            index1++;
            index2++;
            ans++;
        }
        return ans;
    }


//    public int findLength3(int[] nums1, int[] nums2) {
//        //dp[i][j] 表示到nums[i] nums[j]为止，之前最大公共序列长度
//        //dp[i][j] = 0 如果nums1[i] nums2[j]不等
//        //dp[i][j] = max(dp[i][j],dp[i-1][j-1]+1) 如果nums1[i] nums2[j]等
//        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
//        int res = 0;
//        for (int i = 1; i <= nums1.length; i++) {
//            for (int j = 1; j <= nums2.length; j++) {
//                if (nums1[i - 1] == nums2[j - 1]) {
//                    if ((dp[i][j] = dp[i - 1][j - 1] + 1) > res) {
//                        res = dp[i][j];
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    public int findLength2(int[] nums1, int[] nums2) {
//        int[] dp = new int[nums2.length + 1];
//        int res = 0;
//        for (int i = 1; i <= nums1.length; i++) {
//            int pre = dp[0];
//            for (int j = 1; j <= nums2.length; j++) {
//                int cur = dp[j];
//                if (nums1[i - 1] == nums2[j - 1]) {
//                    if ((dp[j] = pre + 1) > res) {
//                        res = dp[j];
//                    }
//                } else {
//                    dp[j] = 0;
//                }
//                pre = cur;
//            }
//        }
//        return res;
//    }
//
//    public int findLength1(int[] nums1, int[] nums2) {
//        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
//        int res = 0;
//        for (int i = 1; i <= nums1.length; i++) {
//            for (int j = 1; j <= nums2.length; j++) {
//                if (nums1[i - 1] == nums2[j - 1]) {
//                    if ((dp[i][j] = dp[i - 1][j - 1] + 1) > res) {
//                        res = dp[i][j];
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    public int findLength(int[] nums1, int[] nums2) {
//        int result = 0;
//        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
//        for (int i = 1; i <= nums1.length; i++) {
//            for (int j = 1; j <= nums2.length; j++) {
//                if (nums1[i - 1] == nums2[j - 1]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                    if (dp[i][j] > result) {
//                        result = dp[i][j];
//                    }
//                }
//            }
//        }
//        return result;
//    }

}
