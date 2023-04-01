package com.lu.dmsxl.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2022-09-20
 */
public class String_q3_1_LengthOfLongestSubstring {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("pwwkewp"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            char c = chars[right];
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            max = Math.max(max, right - left + 1);
            map.put(c, right);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        int length = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < length; right++) {
            char element = s.charAt(right);
            if (map.containsKey(element)) {
                left = Math.max(map.get(element) + 1, left); //map.get()的地方进行+1操作
            }
            max = Math.max(max, right - left + 1);
            map.put(element, right);
        }
        return max;
    }
}
