package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-24
 */
public class rev_双指针_q1163 {

    @Test
    public void test(){
        System.out.println(lastSubstring("leetcode"));
        System.out.println(lastSubstring("abab"));
    }

    public String lastSubstring1(String s) {


        return null;
    }

    public String lastSubstring(String s) {
        String res = s;
        for (int i = 1; i < s.length(); i++) {
            String substring = s.substring(i);
            if (res.compareTo(substring) < 0) {
                res = substring;
            }
        }
        return res;
    }

}
