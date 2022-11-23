package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2022-11-23
 */
public class q1742_0 {

    @Test
    public void test() {
        System.out.println(countBalls(1, 10));
    }

    public int countBalls(int lowLimit, int highLimit) {
        int result = 0;
        int[] resultMap = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = getSum(i);
            resultMap[sum] += 1;
        }
        return Arrays.stream(resultMap).max().orElse(0);
    }

    public static int getSum(int n) {
        int div = 1;
        int res = 0;
        while (n > div) {
            res += n / div % 10;
            div *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getSum(123));
    }

}
