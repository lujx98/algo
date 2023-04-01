package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2022-11-13
 */
public class rev_q791 {

    @Test
    public void test(){
        System.out.println(customSortString("cba","abcd"));
    }

    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.toCharArray().length; i++) {
            map.put(order.charAt(i), order.length() - i);
        }
        char[] a = s.toCharArray();

        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = s.charAt(i);
        }

        Arrays.sort(arr, (v1, v2) -> {
            Integer v1s = map.get(v1);
            Integer v2s = map.get(v2);
            v1s = v1s == null ? 0 : v1s;
            v2s = v2s == null ? 0 : v2s;
            return v2s - v1s;
        });

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }

}
