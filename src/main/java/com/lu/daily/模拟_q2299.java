package com.lu.daily;

import java.util.ArrayList;

/**
 * @author sheldon
 * @date 2023-01-19
 */
public class 模拟_q2299 {

    public boolean strongPasswordCheckerII(String password) {
        char[] chars = password.toCharArray();
        if (chars.length < 8) {
            return false;
        }
        ArrayList<Character> objects = new ArrayList<>();
        for (char c : "!@#$%^&*()-+".toCharArray()) {
            objects.add(c);
        }
        boolean hasLow = false, hasUpper = false, hasNum = false, hasS = false;
        if (chars[0] >= '0' && chars[0] <= '9') {
            hasNum = true;
        }
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            hasLow = true;
        }
        if (chars[0] >= 'A' && chars[0] <= 'Z') {
            hasUpper = true;
        }
        if (objects.contains(chars[0])) {
            hasS = true;
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }

            if (chars[i] >= '0' && chars[i] <= '9') {
                hasNum = true;
            }
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                hasLow = true;
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                hasUpper = true;
            }
            if (objects.contains(chars[i])) {
                hasS = true;
            }
        }
        return hasS && hasUpper && hasLow && hasNum;
    }

}
