package com.lu.all;

import org.junit.Test;

import java.lang.management.PlatformManagedObject;

/**
 * @author sheldon
 * @date 2023-07-26
 */
public class 模拟_q860_柠檬水找零 {

    @Test
    public void test(){
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }

    public boolean lemonadeChange(int[] bills) {
        int remain5 = 0;
        int remain10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                remain5++;
            } else if (bill == 10) {
                if (remain5 < 1) {
                    return false;
                }
                remain10++;
                remain5--;
            } else {
                if (remain10 >= 1 && remain5 >= 1) {
                    remain5--;
                    remain10--;
                } else if (remain5 >= 3) {
                    remain5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
