package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-11-15
 */
public class q1710_0 {

    @Test
    public void test() {
        System.out.println(maximumUnits(new int[][]{new int[]{1, 3}, new int[]{2, 2}, new int[]{3, 1}}, 4));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] < truckSize) {
                res += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                res += truckSize * boxType[1];
                break;
            }
        }
        return res;
    }

}
