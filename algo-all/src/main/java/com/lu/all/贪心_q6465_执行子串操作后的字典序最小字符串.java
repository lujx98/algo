package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-11
 */
public class 贪心_q6465_执行子串操作后的字典序最小字符串 {

    @Test
    public void test() {
        System.out.println(smallestString("aa"));
    }

    public String smallestString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        boolean changed = false;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                stringBuilder.append('a');
                continue;
            }
            changed = false;
            while (i < s.length() && s.charAt(i) != 'a') {
                stringBuilder.append((char) (s.charAt(i) - 1));
                i++;
            }
            break;
        }
        stringBuilder.append(s.substring(i));
        if (!changed) {
            char c = stringBuilder.toString().charAt(stringBuilder.length() - 1);
            if (c == 'a') {
                c = 'z';
            } else {
                c = (char) (c - 1);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(c);
        }
        return stringBuilder.toString();
    }

}
