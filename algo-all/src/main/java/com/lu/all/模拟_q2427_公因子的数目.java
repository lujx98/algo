package com.lu.all;

/**
 * @author sheldon
 * @date 2023-04-05
 */
public class 模拟_q2427_公因子的数目 {

    public int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int count = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

}
