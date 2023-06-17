package com.lu.all;

/**
 * @author sheldon
 * @date 2023-06-17
 */
public class 模拟_q2481_分割圆的最少切割次数 {

    public int numberOfCuts(int n) {
        //1 3 2 5 3
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return n;
        }
    }

}
