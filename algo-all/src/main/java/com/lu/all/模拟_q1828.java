package com.lu.all;

/**
 * @author sheldon
 * @date 2023-01-24
 */
public class 模拟_q1828 {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int midX = queries[i][0];
            int midY = queries[i][1];
            int r = queries[i][2];
            for (int[] point : points) {
                if (!(point[0] <= midX + r
                        && point[0] >= midX - r
                        && point[1] >= midY - r
                        && point[1] <= midY + r)) {
                    continue;
                }
                if ((point[0] - midX) * (point[0] - midX) + (point[1] - midY) * (point[1] - midY) <= r * r) {
                    res[i]++;
                }
            }
        }
        return res;
    }

}
