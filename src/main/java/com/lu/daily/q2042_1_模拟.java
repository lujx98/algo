package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-03
 */
public class q2042_1_模拟 {

    @Test
    public void test(){
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 3 green and 12 yellow marbles"));
    }

    public boolean areNumbersAscending(String s) {
        String[] s1 = s.split(" ");
        int cur = Integer.MIN_VALUE;
            for (String s2 : s1) {
            if (isDigit(s2)) {
                int integer = Integer.parseInt(s2);
                if (integer > cur) {
                    cur = integer;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isDigit(String s2) {
        for (char c : s2.toCharArray()) {
            if (!(Character.isDigit(c))) {
                return false;
            }
        }
        return true;
    }

}
