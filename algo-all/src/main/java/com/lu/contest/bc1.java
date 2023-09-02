package com.lu.contest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-08-27
 */
public class bc1 {

    @Test
    public void test() {
        System.out.println();
    }

    public boolean canBeEqual(String s1, String s2) {
        int[] ints = new int[]{s1.charAt(0), s1.charAt(2)};
        int[] ints1 = new int[]{s2.charAt(0), s2.charAt(2)};
        Arrays.sort(ints);
        Arrays.sort(ints1);
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != ints1[i]) {
                return false;
            }
        }

        int[] i2 = new int[]{s1.charAt(1), s1.charAt(3)};
        int[] i1 = new int[]{s2.charAt(1), s2.charAt(3)};
        Arrays.sort(i2);
        Arrays.sort(i1);
        for (int i = 0; i < i2.length; i++) {
            if (i2[i] != i1[i]) {
                return false;
            }
        }

        return true;
    }

}
