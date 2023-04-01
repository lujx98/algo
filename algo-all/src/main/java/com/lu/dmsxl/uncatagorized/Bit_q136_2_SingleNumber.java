package com.lu.dmsxl.uncatagorized;

/**
 * @author sheldon
 * @date 2022-09-18
 */
public class Bit_q136_2_SingleNumber {

    public int singleNumber(int[] nums) {
        int a =0;
        for (int num : nums) {
            a=a^num;
        }
        return a;
    }

}
