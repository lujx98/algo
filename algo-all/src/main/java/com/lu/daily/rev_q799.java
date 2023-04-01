package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-11-20
 */
public class rev_q799 {

    @Test
    public void test() {
        System.out.println(champagneTower(25, 6, 1));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] temp = {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] nextRow = new double[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    nextRow[j] = (temp[j] > 1 ? (temp[j] - 1) : 0) / 2;
                } else if (j == i) {
                    nextRow[j] = (temp[j - 1] > 1 ? (temp[j - 1] - 1) : 0) / 2;
                } else {
                    nextRow[j] = (temp[j - 1] > 1 ? (temp[j - 1] - 1) : 0) / 2 + (temp[j] > 1 ? (temp[j] - 1) : 0) / 2;
                }
            }
            temp = nextRow;
        }
        return Math.min(temp[query_glass], 1D);
    }

//    public double champagneTower(int poured, int query_row, int query_glass) {
//        int cur = 0;
//        while (true) {
//            if (poured < (cur * (1 + cur) / 2)) {
//                break;
//            }
//            cur++;
//        }
//        int b = --cur;
//        int i = poured - (cur * (1 + cur) / 2);
//        if (query_row < b) {
//            return 1D;
//        } else if (query_row == b && (i == poured)) {
//            return 0D;
//        }
//        int part = 2 * query_row;
//        double part1 = (double)i / part;
//        if (query_glass == 0 || query_glass == query_row) {
//            return part1;
//        } else {
//            return part1 * 2;
//        }
//    }

}
