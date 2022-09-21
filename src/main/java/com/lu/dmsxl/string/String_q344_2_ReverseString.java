package com.lu.dmsxl.string;

/**
 * @author sheldon
 * @date 2022-09-21
 */
public class String_q344_2_ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
