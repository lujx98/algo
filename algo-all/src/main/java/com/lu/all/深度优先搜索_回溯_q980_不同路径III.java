package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-08-04
 */
public class 深度优先搜索_回溯_q980_不同路径III {

    @Test
    public void test() {
        System.out.println(uniquePathsIII(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 2}}));
    }

    private boolean[][] visited;
    private int[][] grid;
    private int[] d = new int[]{-1, 0, 1};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1) {
            return 0;
        }
        if ((grid[x][y] != 2 && visited[x][y]) || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            visited[x][y] = true;
            return check() ? 1 : 0;
        }
        int res = 0;
        visited[x][y] = true;
        for (int dx : d) {
            for (int dy : d) {
                if ((dx == 0 && dy == 0) || Math.abs(dx) == Math.abs(dy)) {
                    continue;
                }
                int dfs = dfs(x + dx, y + dy);
                res += dfs;
            }
        }
        visited[x][y] = false;
        return res;
    }

    private boolean check() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != -1) {
                    return false;
                }
            }
        }
        return true;
    }

}
