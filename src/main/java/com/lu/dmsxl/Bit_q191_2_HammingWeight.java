package com.lu.dmsxl;

/**
 * @author sheldon
 * @date 2022-09-19
 */
public class Bit_q191_2_HammingWeight {

    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        do {
            count++;
            n &= (n - 1);
        }
        while (n != 0);
        return count;
    }

}
