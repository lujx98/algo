package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sheldon
 * @date 2023-03-30
 */
public class 模拟_q1637_两点之间不包含任何点的最宽垂直区域 {

    @Test
    public void test(){

    }

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(v -> v[0]));
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            res = Math.max(points[i][0] - points[i - 1][0], res);
        }
        return res;
    }

}
