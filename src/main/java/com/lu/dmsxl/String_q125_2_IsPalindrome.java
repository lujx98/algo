package com.lu.dmsxl;

import org.junit.Test;

import java.util.Locale;

/**
 * @author sheldon
 * @date 2022-09-18
 */
public class String_q125_2_IsPalindrome {

    @Test
    public void test() {
        System.out.println(isPalindrome("ab2a"));
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        String s1 = s.toLowerCase(Locale.ROOT);
        int left = 0, right = s1.length() - 1;
        Boolean is = true;
        while (left < right) {
            while (left < right && !(s1.charAt(left) >= 97 && s1.charAt(left) <= 122)&& !(s1.charAt(left) >= 48 && s1.charAt(left) <= 57)) {
                left++;
            }
            while (left < right && !(s1.charAt(right) >= 97 && s1.charAt(right) <= 122)&& !(s1.charAt(right) >= 48 && s1.charAt(right) <= 57)) {
                right--;
            }
            if (s1.charAt(right) != s1.charAt(left)) {
                return false;
            }
            left++;
            right--;
        }
        return is;
    }

}
