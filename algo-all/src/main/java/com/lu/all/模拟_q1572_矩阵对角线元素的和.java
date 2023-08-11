package com.lu.all;

/**
 * @author sheldon
 * @date 2023-08-11
 */
public class 模拟_q1572_矩阵对角线元素的和 {

    private int[][] mat;

    public int diagonalSum(int[][] mat) {
        this.mat = mat;
        int i = dfs(0, 0, 1) + dfs(0, mat[0].length - 1, -1);
        if (mat.length % 2 != 0) {
            i -= mat[mat.length / 2][mat.length / 2];
        }
        return i;
    }

    public int dfs(int depth, int index, int incurment) {
        if (depth >= mat.length || index < 0 || index > mat[0].length - 1) {
            return 0;
        }
        return mat[depth][index] + dfs(depth + 1, index + incurment, incurment);
    }

}
