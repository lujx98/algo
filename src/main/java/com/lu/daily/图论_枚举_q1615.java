package com.lu.daily;

/**
 * @author sheldon
 * @date 2023-03-15
 */
public class 图论_枚举_q1615 {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        boolean[][] connect = new boolean[n][n];
        for (int[] road : roads) {
            connect[road[0]][road[1]] = true;
            connect[road[1]][road[0]] = true;

            count[road[0]]++;
            count[road[1]]++;
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = count[i] + count[j] - (connect[i][j] ? 1 : 0);
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }

}
