package com.lu.daily;

/**
 * @author sheldon
 * @date 2022-12-01
 */
public class q1779_1 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] != x && points[i][1] != y) {
                continue;
            }
            int ge = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
            if (ge < min) {
                index = i;
                min = ge;
            }
        }
        return index;
    }

}
