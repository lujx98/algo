package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-08-24
 */
public class 模拟_q1267_统计参与通信的服务器 {

    @Test
    public void test() {
        System.out.println(countServers(ArrayUtils.makeIntArraysByString("[[1,0],[0,1]]")));
    }

    public int countServers(int[][] grid) {
        int[] x = new int[grid.length];
        int[] y = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x[i]++;
                    y[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (x[i] > 1 || y[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }

}
