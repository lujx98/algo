package com.lu.all;

import com.lu.utils.ArraysUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-19
 */
public class rev_q1254 {

    @Test
    public void test(){
        int[][] grid = ArraysUtils.makeIntArraysByString("[[0,0,1,1,0,1,0,0,1,0],[1,1,0,1,1,0,1,1,1,0],[1,0,1,1,1,0,0,1,1,0],[0,1,1,0,0,0,0,1,0,1],[0,0,0,0,0,0,1,1,1,0],[0,1,0,1,0,1,0,1,1,1],[1,0,1,0,1,1,0,0,0,1],[1,1,1,1,1,1,0,0,0,0],[1,1,1,0,0,1,0,1,0,1],[1,1,1,0,1,1,0,1,1,0]]");
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(closedIsland(grid));
    }

    private int[][] grid;

    public int closedIsland(int[][] grid) {
        System.out.println("");
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                eliminate(i, 0);
            }
            if (grid[i][grid[0].length - 1] == 0) {
                eliminate(i, grid[0].length - 1);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 0) {
                eliminate(0, i);
            }
            if (grid[grid.length - 1][i] == 0) {
                eliminate(grid.length - 1, i);
            }
        }
        print();
        int res = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    eliminate(i, j);
                }
            }
        }
        return res;
    }

    private void eliminate(int x, int y) {
        if (x >= grid.length || x < 0 || y < 0 || y >= grid[0].length || grid[x][y] == 1) {
            return;
        }
        grid[x][y] = 1;
        eliminate(x + 1, y);
        eliminate(x - 1, y);
        eliminate(x, y + 1);
        eliminate(x, y - 1);
    }

    private void print(){
        for (int[] ints : this.grid) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
