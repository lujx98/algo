package com.lu.dmsxl.uncatagorized;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-16
 */
public class q9IsPalindrome {

    @Test
    public void test(){
        System.out.println(isPalindrome(2112));
    }

    public boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        String xs = String.valueOf(x);
        int first = 0;
        int second = xs.length() - 1;
        if (x < 0) {
            return false;
        }
        while (first < second) {
            if (xs.charAt(first) != xs.charAt(second)) {
                isPalindrome = false;
                break;
            }
            first++;
            second--;
        }
        return isPalindrome;
    }

}
