package com.lu.all;

import com.lu.utils.ArraysUtils;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author sheldon
 * @date 2023-05-26
 */
public class rev_q1091 {

    @Test
    public void test() {
        System.out.println(shortestPathBinaryMatrix(ArraysUtils.makeIntArraysByString("[0,0,0],[0,0,0],[0,0,0]")));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        int round = 1;
        while (!queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (x + dx < 0 || x + dx >= grid.length || y + dy < 0 || y + dy >= grid[0].length) {
                            continue;
                        }
                        if (grid[x + dx][y + dy] == 1 || visited[x + dx][y + dy]) {
                            continue;
                        }
                        if (x + dx == grid.length - 1 && y + dy == grid[0].length - 1) {
                            return round;
                        }
                        visited[x + dx][y + dy] = true;
                        queue.offer(new int[]{x + dx, y + dy});
                    }
                }
            }
        }
        return -1;
    }

}
