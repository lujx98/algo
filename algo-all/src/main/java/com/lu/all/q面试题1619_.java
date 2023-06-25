package com.lu.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-06-25
 */
public class q面试题1619_ {

    public int[] pondSizes(int[][] land) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    res.add(doEli(land, i, j));
                }
            }
        }
        return null;
    }

    private int doEli(int[][] land, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i >= land.length || j > land[0].length) {
            return 0;
        }
        if (land[i][j] == 0) {
            return 0;
        }
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
