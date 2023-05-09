package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author sheldon
 * @date 2023-05-06
 */
public class 模拟_q1419_数青蛙 {

    @Test
    public void test() {
        System.out.println(minNumberOfFrogs("croakcroak"));
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] ints = new int[5];
        int res = 0;
        int max = 0;
        int min;
        for (char c : croakOfFrogs.toCharArray()) {
            int index = getIndex(c);
            ints[index]++;
            if (index > 0 && ints[index] > ints[index - 1]) {
                return -1;
            }
            max = Math.max(max, ints[index]);
            min = Arrays.stream(ints).min().getAsInt();
            res = Math.max(res, max - min);
        }
        if (ints[4] != ints[0]) {
            return -1;
        }
        return res;
    }

    private int getIndex(char c) {
        if (c == 'c') {
            return 0;
        } else if (c == 'r') {
            return 1;
        } else if (c == 'o') {
            return 2;
        } else if (c == 'a') {
            return 3;
        } else {
            return 4;
        }
    }

}
