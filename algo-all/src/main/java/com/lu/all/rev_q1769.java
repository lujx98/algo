package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-12-02
 */
public class rev_q1769 {

    @Test
    public void test() {
        int[] ints = minOperations("001011");
        System.out.println("001011".charAt(0));
        System.out.println(Arrays.toString(ints));
    }

    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            if ((boxes.charAt(i)) == '0') {
                continue;
            }

            for (int j = 0; j < length; j++) {
                res[j] += Math.abs(j - i);
            }

//            for (int j = length - 1; j >= 0; j--) {
//                res[j] += Math.abs(length - 1 - j - i);
//            }
        }
        return res;
    }

}
