package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-08-21
 */
public class 模拟_q2337_移动片段得到字符串 {

    @Test
    public void test() {
        System.out.println(canChange("_L__R__R_"
                , "L______RR"));
    }

    public boolean canChange(String start, String target) {
        if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
            return false;
        }

        int count = 0;
        for (int length = start.length() - 1; length >= 0; length--) {
            if (target.charAt(length) == 'R') {
                count++;
            }
            if (start.charAt(length) == 'R') {
                if (count != 0) {
                    count--;
                } else {
                    return false;
                }
            }
        }

        count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (target.charAt(i) == 'L') {
                count++;
            }
            if (start.charAt(i) == 'L') {
                if (count != 0) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
