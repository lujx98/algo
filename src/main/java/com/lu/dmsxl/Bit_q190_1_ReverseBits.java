package com.lu.dmsxl;

/**
 * @author sheldon
 * @date 2022-09-19
 */
public class Bit_q190_1_ReverseBits {

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i <= 31; i++) {
            int i1 = (1 & n >> i) << (31 - i);
            rev += (i1);
        }
        return rev;
    }

}
