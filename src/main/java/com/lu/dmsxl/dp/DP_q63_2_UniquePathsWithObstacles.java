package com.lu.dmsxl.dp;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-05-31
 */
public class DP_q63_2_UniquePathsWithObstacles {
    @Test
    public void test() {
        System.out.println(uniquePaths1(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public int uniquePaths1(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] ints = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ints[j] = 0;
                    continue;
                }
                if ((j == 0 || i == 0)) {
                    ints[j] = 1;
                    continue;
                }
                ints[j] += ints[j - 1];
            }
        }
        return ints[n - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid.length == 1) {
            return 0;
        }
        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                obstacleGrid[0][j] = 0;
            } else {
                obstacleGrid[0][j] = 1;
            }
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (i == 0) {
                continue;
            }
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = 1;
                    }
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }
//        return obstacleGrid;
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 1) {
            return 0;
        }
        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                obstacleGrid[0][j] = 0;
            } else {
                obstacleGrid[0][j] = 1;
            }
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (i == 0) {
                continue;
            }
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = 1;
                    }
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
            }
        }
//        return obstacleGrid;
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

}
