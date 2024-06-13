package com.lu.all;

/**
 * @author sheldon
 * @date 2023-12-21
 */
public class 模拟_q135_分发糖果 {

    public int candy(int[] ratings) {
        int res = 1, prevC = 1, decLengh = 0, incMax = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (ratings[i] == ratings[i - 1]) {
                    res++;
                    prevC = 1;
                } else {
                    res += prevC + 1;
                    prevC++;
                }
                incMax = prevC;
                decLengh = 0;
            } else {
                decLengh++;
                if (decLengh == incMax) {
                    decLengh++;
                }
                res += decLengh;
                prevC = 1;
            }
        }
        return res;
    }

}
