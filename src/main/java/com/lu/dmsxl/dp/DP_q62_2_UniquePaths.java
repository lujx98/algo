package com.lu.dmsxl.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-05-31
 */
public class DP_q62_2_UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] ints = new int[m];
        Arrays.fill(ints, 1);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(ints);
        for (int i = 1; i < n; i++) {
            int[] intsin = new int[m];
            intsin[0] = 1;
            for (int j = 1; j < m; j++) {
                intsin[j] = intsin[j - 1] + list.get(i - 1)[j];
            }
            list.add(intsin);
        }
        return list.get(n - 1)[m];
    }

    @Test
    public void test() {
        System.out.println(uniquePaths1(3, 7));
    }

    public int uniquePaths1(int m, int n) {
        int[] ints = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0) {
                    ints[j] = 1;
                    continue;
                }
                ints[j] += ints[j - 1];
            }
        }
        return ints[n - 1];
    }

}
