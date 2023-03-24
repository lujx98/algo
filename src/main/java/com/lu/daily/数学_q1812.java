package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-08
 */
public class 数学_q1812 {

    @Test
    public void test() {
        System.out.println('h' - '`');
        System.out.println(squareIsWhite("a2"));
    }

    public boolean squareIsWhite(String coordinates) {
        return !((coordinates.charAt(0) - '`') % 2 == coordinates.charAt(1) % 2);
    }

}
