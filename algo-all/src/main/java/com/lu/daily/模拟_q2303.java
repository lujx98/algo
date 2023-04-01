package com.lu.daily;

import com.lu.structure.ArraysUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-23
 */
public class 模拟_q2303 {

    @Test
    public void test(){
        System.out.println(calculateTax(ArraysUtils.makeIntArraysByString("[[3,50],[7,10],[12,25]]"), 10));
    }

    public double calculateTax(int[][] brackets, int income) {
        double res = 0.0;
        int cut = 0;
        for (int[] bracket : brackets) {
            if (income < bracket[0]) {
                res += (income - cut) * (double) bracket[1] / 100;
                break;
            } else {
                res += (bracket[0] - cut) * (double) bracket[1] / 100;
            }
            cut = bracket[0];
        }
        return res;
    }

}
