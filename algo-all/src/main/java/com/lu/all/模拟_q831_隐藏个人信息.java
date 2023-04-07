package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-01
 */
public class 模拟_q831_隐藏个人信息 {

    @Test
    public void test(){
        System.out.println(maskPII("1(234)567-890"));
    }

    private final static String MOBILE_PREFIX = "***-***-";

    public String maskPII(String s) {
        char c = s.charAt(s.length() - 1);
        if (Character.isAlphabetic(c)) {
            return getEmail(s);
        } else {
            return getMobileNumber(s);
        }
    }

    private String getMobileNumber(String s) {
        StringBuilder stringBuilder1 = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '+' && c != '-' && c != '(' && c != ')' && c != ' ') {
                stringBuilder1.append(c);
            }
        }
        s = stringBuilder1.toString();
        StringBuilder stringBuilder = new StringBuilder();
        if (s.length() == 10) {
            stringBuilder.append(MOBILE_PREFIX);
            stringBuilder.append(s.substring(s.length() - 4));
        } else {
            stringBuilder.append("+");
            for (int i = 0; i < s.length() - 10; i++) {
                stringBuilder.append("*");
            }
            stringBuilder.append("-");
            stringBuilder.append(MOBILE_PREFIX);
            stringBuilder.append(s.substring(s.length() - 4));
        }
        return stringBuilder.toString();
    }

    private String getEmail(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            if (s.charAt(i) == '@') {
                index = i;
            }
        }
        stringBuilder.append(String.valueOf(s.charAt(0)).toLowerCase());
        stringBuilder.append("*****");
        stringBuilder.append(String.valueOf(s.charAt(index - 1)).toLowerCase());
        stringBuilder.append(s.substring(index).toLowerCase());
        return stringBuilder.toString();
    }

}
