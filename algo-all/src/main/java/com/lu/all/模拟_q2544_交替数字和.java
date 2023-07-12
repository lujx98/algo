package com.lu.all;

/**
 * @author sheldon
 * @date 2023-07-12
 */
public class 模拟_q2544_交替数字和 {

    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int res = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            res += ((s.charAt(i) - '0') * (1 - 2 * temp));
            temp ^= 1;
        }
        return res;
    }

}
