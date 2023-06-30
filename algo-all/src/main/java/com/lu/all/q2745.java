package com.lu.all;

import java.util.Map;

/**
 * @author sheldon
 * @date 2023-06-30
 */
public class q2745 {

    public int longestString(int x, int y, int z) {
        if (x == y) {
            return 2 * z + 4 * y;
        } else {
            return 2 * z + 2 * (2 * Math.min(x, y) + 1);
        }
    }

}
