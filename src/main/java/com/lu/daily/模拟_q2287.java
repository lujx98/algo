package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-13
 */
public class 模拟_q2287 {

    @Test
    public void test() {
        System.out.println(rearrangeCharacters("abc", "abcdy"));
    }

    public int rearrangeCharacters(String s, String target) {
        int[] weight = new int[26];
        for (char c : target.toCharArray()) {
            weight[c - 'a']++;
        }
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            if (weight[c - 'a'] != 0) {
                freq[c - 'a']++;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                res = Math.min(res, freq[i] / weight[i]);
            } else if (weight[i] != 0) {
                return 0;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
