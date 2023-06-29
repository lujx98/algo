package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-06-25
 */
public class 模拟_q面试题1619_水域大小 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(pondSizes(ArrayUtils.makeIntArraysByString("[[0,2,1,0],[0,1,0,1],[1,1,0,1],[0,1,0,1]]"))));
    }

    public int[] pondSizes(int[][] land) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    res.add(doEli(land, i, j));
                }
            }
        }
        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }
        Arrays.sort(ints);
        return ints;
    }

    private int doEli(int[][] land, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i >= land.length || j >= land[0].length) {
            return 0;
        }
        if (land[i][j] != 0) {
            return 0;
        }
        land[i][j] = 1;
        return 1 + doEli(land, i + 1, j)
                + doEli(land, i + 1, j + 1)
                + doEli(land, i + 1, j - 1)
                + doEli(land, i, j - 1)
                + doEli(land, i, j + 1)
                + doEli(land, i - 1, j + 1)
                + doEli(land, i - 1, j)
                + doEli(land, i - 1, j - 1);
    }

}
