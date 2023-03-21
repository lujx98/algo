package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-01
 */
public class 模拟_q2325 {

    @Test
    public void test() {
        char a = 97;
        System.out.println(a);
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }

    public String decodeMessage(String key, String message) {
        char[] keys = key.toCharArray();
        char[] messages = message.toCharArray();
        char[] rKey = new char[26];
        int index = 0;
        int mask = 0;
        for (int i = 0; i < rKey.length; i++, index++) {
            char key1 = keys[index];
            while ((mask >> (key1 - 'a') & 1) == 1 || key1 == ' ') {
                index++;
                key1 = keys[index];
            }
            rKey[key1 - 'a'] = (char) ('a' + i);
            mask |= 1 << key1 - 'a';
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : messages) {
            if (c == ' ') {
                stringBuilder.append(c);
                continue;
            }
            int index1 = c - 'a';
            char key1 = rKey[index1];
            stringBuilder.append(key1);
        }
        return stringBuilder.toString();
    }

}