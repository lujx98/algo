package com.lu.all;

/**
 * @author sheldon
 * @date 2023-02-17
 */
public class rev_q1139 {

    public int largest1BorderedSquare(int[][] grid) {
        int rowLength = grid.length, columnLength = grid[0].length;
        int[][] rowPrefix = new int[rowLength][columnLength + 1], columnPrefix = new int[rowLength + 1][columnLength];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rowPrefix[i][j+1]  = rowPrefix[i][j] + grid[i][j];
                columnPrefix[i+1][j] = columnPrefix[i][j] + grid[i][j];
            }
        }

        return 0;
    }

}
