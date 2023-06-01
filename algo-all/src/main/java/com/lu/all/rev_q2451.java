package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-05-25
 */
public class rev_q2451 {

    @Test
    public void test() {
        System.out.println(oddString(new String[]{"adc", "wzy", "abc"}));
    }

    public String oddString(String[] words) {
        HashMap<List<Integer>, String> res = new HashMap<>();
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for (String word : words) {
            List<Integer> ints = new ArrayList<>(word.length());
            for (int i = 1; i < word.toCharArray().length; i++) {
                ints.add(word.charAt(i) - word.charAt(i - 1));
            }
            res.put(ints, word);
            if (map.containsKey(ints)) {
                map.put(ints, map.get(ints) + 1);
            } else {
                map.put(ints, 1);
            }
        }
        for (List<Integer> integers : map.keySet()) {
            if (map.get(integers) == 1) {
                return res.get(integers);
            }
        }
        return null;
    }

}
