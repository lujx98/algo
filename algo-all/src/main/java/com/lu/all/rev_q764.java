package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/largest-plus-sign/
 *
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 *
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 *
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * 示例 2：
 *
 *
 *
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 *
 * @author sheldon
 * @date 2022-11-09
 */
public class rev_q764 {

    @Test
    public void test() {
        System.out.println(orderOfLargestPlusSign(5, new int[][]{new int[]{4, 2}}));
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] board = new int[n][n];
        for (int[] ints : board) {
            Arrays.fill(ints, 1);
        }
        for (int[] mine : mines) {
            int left = mine[0];
            int right = mine[1];
            board[left][right] = 0;
        }
        int[][] down = new int[n][n];
        int[][] right = new int[n][n];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    down[i][j] = 0;
                    right[i][j] = 0;
                } else {
                    //棋盘上为1
                    down[i][j] = i == 0 ? 1 : down[i - 1][j] + 1;
                    right[i][j] = j == 0 ? 1 : right[i][j - 1] + 1;
                }
            }
        }

        int[][] up = new int[n][n];
        int[][] left = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board[i][j] == 0) {
                    up[i][j] = 0;
                    left[i][j] = 0;
                } else {
                    //棋盘上为1
                    up[i][j] = i == n - 1 ? 1 : up[i + 1][j] + 1;
                    left[i][j] = j == n - 1 ? 1 : left[i][j + 1] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, Math.min(Math.min(up[i][j], left[i][j]), Math.min(down[i][j], right[i][j])));
            }
        }

        return max;
    }

}
