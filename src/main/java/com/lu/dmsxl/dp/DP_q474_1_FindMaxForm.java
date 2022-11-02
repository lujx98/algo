package com.lu.dmsxl.dp;

/**
 * @author sheldon
 * @date 2022-08-25
 */
public class DP_q474_1_FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int oneNumber = 0;
            int zeroNumber = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroNumber++;
                } else {
                    oneNumber++;
                }
            }
            for (int i = m; i >= zeroNumber; i--) {
                for (int j = n; j >= oneNumber; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNumber][j - oneNumber] + 1);
                }
            }
        }
        return dp[m][n];
    }

//    public int findMaxForm1(String[] strs, int m, int n) {
//
//
//        int[][] ints = new int[m + 1][n + 1];
//        for (String str : strs) {
//            int zeroNumber = 0;
//            int oneNumber = 0;
//            for (char c : str.toCharArray()) {
//                if (c=='0'){
//                    zeroNumber++;
//                }else {
//                    oneNumber++;
//                }
//            }
//
//
//        }
//        return ints[m][n];
//    }
//
//    public int findMaxForm(String[] strs, int m, int n) {
//        int[][] ints = new int[m+1][n+1];
//        for (String str : strs) {
//            int oneNumber = 0,zeroNumber = 0;
//            for (char c : str.toCharArray()) {
//                if (c == '1') {
//                    oneNumber++;
//                }else {
//                    zeroNumber++;
//                }
//            }
//            for (int i = m; i >= zeroNumber; i--) {
//                for (int j = n; j >= oneNumber; j--) {
//                    ints[i][j] = Math.max(ints[i][j],ints[i-zeroNumber][j-oneNumber]+1);
//                }
//            }
//        }
//        return ints[m][n];
//    }

}
