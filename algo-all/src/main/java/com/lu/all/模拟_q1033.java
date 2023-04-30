package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-04-30
 */
public class 模拟_q1033 {

    public int[] numMovesStones(int a, int b, int c) {
        int[] res = new int[2];
        int[] ints = {a, b, c};
        Arrays.sort(ints);
        if (ints[1] - ints[0] == 2 || ints[2] - ints[1] == 2) {
            res[0] = 1;
        } else {
            res[0] = (ints[2] != ints[1] + 1 ? 1 : 0) + (ints[0] != ints[1] - 1 ? 1 : 0);
        }
        res[1] = (ints[1] - ints[0] - 1) + (ints[2] - ints[1] - 1);
        return res;
    }

}
