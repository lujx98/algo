package com.lu.dmsxl.twopointer;

public class Two_q344_2_ReverseString {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp ;
            temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }

//    public void reverseString(char[] s) {
//        int left = 0, right = s.length - 1;
//        while (left < right) {
//            s[left] ^= s[right];
//            s[right] ^= s[left];
//            s[left] ^= s[right];
//            left++;
//            right++;
//        }
//    }

//    public void reverseString(char[] s) {
//        int left = 0;
//        int right = s.length - 1;
//        while (left < right) {
//            s[left] ^= s[right];
//            s[right] ^= s[left];
//            s[left] ^= s[right];
//            left++;
//            right--;
//        }
//    }

}
