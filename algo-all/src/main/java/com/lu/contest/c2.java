package com.lu.contest;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class c2 {

    @Test
    public void test() {
        System.out.println(shortestBeautifulSubstring("1011"
                , 2));
    }

    public String shortestBeautifulSubstring(String s, int k) {
        int count = 0;
        String res = "";
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            String a = s.substring(left, right + 1);
            if (s.charAt(right) == '1') {
                count++;
            }
            while (count == k) {
                if ("".equals(res) || (res.length() > s.substring(left, right + 1).length())) {
                    res = s.substring(left, right + 1);
                }else if (res.length() == s.substring(left, right + 1).length()&&res.compareTo(s.substring(left, right + 1)) > 0){
                    res = s.substring(left, right + 1);
                }
                if (s.charAt(left++) == '1') {
                    count--;
                }
            }
        }
        return res;
    }

}
