package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-08-25
 */
public class 动态规划_q474_一和零 {

    @Test
    public void test(){
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] ints = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int zCount = 0;
            int oCount = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '1') {
                    oCount++;
                } else {
                    zCount++;
                }
            }
            ints[i] = new int[]{zCount, oCount};
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < ints.length; i++) {
            for (int j = dp.length - 1; j >= ints[i][0]; j--) {
                for (int z = dp[0].length - 1; z >= ints[i][1]; z--) {
                    dp[j][z] = Math.max(dp[j][z], dp[j - ints[i][0]][z - ints[i][1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

//    public int findMaxForm(String[] strs, int m, int n) {
//        int[][] dp = new int[m + 1][n + 1];
//        for (String str : strs) {
//            int oneNumber = 0;
//            int zeroNumber = 0;
//            for (char c : str.toCharArray()) {
//                if (c == '0') {
//                    zeroNumber++;
//                } else {
//                    oneNumber++;
//                }
//            }
//            for (int i = m; i >= zeroNumber; i--) {
//                for (int j = n; j >= oneNumber; j--) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNumber][j - oneNumber] + 1);
//                }
//            }
//        }
//        return dp[m][n];
//    }

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
