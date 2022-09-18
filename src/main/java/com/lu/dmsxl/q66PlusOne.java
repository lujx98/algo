package com.lu.dmsxl;

import java.util.*;

/**
 * @author sheldon
 * @date 2022-09-18
 */
public class q66PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                if (i == 0) {
                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                    return digits;
                }
                digits[i] = 0;
                continue;
            }
            digits[i]++;
            break;
        }
        return digits;
    }

}
