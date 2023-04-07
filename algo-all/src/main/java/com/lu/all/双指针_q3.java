package com.lu.all;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-03-26
 */
public class 双指针_q3 {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int right = 0, left = 0; right < s.length(); ) {
            HashSet<Character> set = new HashSet<>();
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - left);
            right = left + 1;
            left++;
        }
        return ans;
    }

}
