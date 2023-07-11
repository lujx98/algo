package com.lu.all;

import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-07-07
 */
public class 双指针_滑动窗口_q438_找到字符串中所有字母异位词 {

    @Test
    public void test() {
        System.out.println(findAnagrams("aaaaaaaaaa"
                , "aaaaaaaaaaaaa"
        ));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        int left = 0;
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            if (map.containsKey(p.charAt(i) - 'a')) {
                map.put(p.charAt(i) - 'a', map.get(p.charAt(i) - 'a') + 1);
            } else {
                map.put(p.charAt(i) - 'a', 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int right = p.length() - 1; right < s.length(); ) {
            if (check(map, count)) {
                res.add(left);
            }
            if (right == s.length() - 1) {
                break;
            }
            count[s.charAt(++right) - 'a']++;
            count[s.charAt(left++) - 'a']--;
        }
        return res;
    }

    private boolean check(Map<Integer, Integer> map, int[] count) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count[entry.getKey()] != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
