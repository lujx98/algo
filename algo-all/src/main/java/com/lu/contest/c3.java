package com.lu.contest;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class c3 {

    @Test
    public void test() {
        System.out.println(minimumMoves(ArrayUtils.makeIntArraysByString("[[3,2,0],[0,1,0],[0,3,0]]")));
    }

    public int minimumMoves(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] > 1) {
                    map.put(i + "" + j, grid[i][j]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    String lessNode = null;
                    int lessCost = Integer.MAX_VALUE;
                    int lessCostValue = Integer.MIN_VALUE;
                    for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                        String key = stringIntegerEntry.getKey();
                        int ti = key.charAt(0) - '0';
                        int tj = key.charAt(1) - '0';
                        int curCost = Math.abs(ti - i) + Math.abs(tj - j);
                        if (curCost < lessCost || (curCost == lessCost && lessCostValue <= stringIntegerEntry.getValue())) {
                            lessCost = curCost;
                            lessNode = stringIntegerEntry.getKey();
                            lessCostValue = stringIntegerEntry.getValue();
                        }
                    }
                    map.merge(lessNode, -1, Integer::sum);
                    if (map.get(lessNode) == 1) {
                        map.remove(lessNode);
                    }
                    res += lessCost;
                }
            }
        }

        return res;
    }

}
