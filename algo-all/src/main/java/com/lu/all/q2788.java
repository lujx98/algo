package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-07-25
 */
public class q2788 {

    @Test
    public void test() {
        System.out.println(splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.'));
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        String s = "\\" + Character.valueOf(separator).toString();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String[] split = word.split(s);
            for (String s1 : split) {
                res.add(s1);
            }
        }
        res.removeIf(a -> a.equals(""));
        return res;
    }

}
