package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-08
 */
public class q2185_1_模拟 {

    @Test
    public void test() {
        System.out.println(prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
    }

    public int prefixCount(String[] words, String pref) {
        int res = 0;
        char[] prefArray = pref.toCharArray();
        searchint:
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < prefArray.length; i++) {
                if (i >= word.length() || chars[i] != prefArray[i]) {
                    continue searchint;
                }
            }
            res++;
        }
        return res;
    }

}
