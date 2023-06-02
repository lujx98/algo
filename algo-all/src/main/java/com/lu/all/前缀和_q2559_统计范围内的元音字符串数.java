package com.lu.all;

import org.junit.Test;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sheldon
 * @date 2023-06-02
 */
public class 前缀和_q2559_统计范围内的元音字符串数 {

    @Test
    public void test() {
        String s = "1234";
        System.out.println(s.charAt(s.length()));
    }

    private Set<Character> set = new HashSet<>();

    public int[] vowelStrings(String[] words, int[][] queries) {
        this.set.add('a');
        this.set.add('e');
        this.set.add('i');
        this.set.add('o');
        this.set.add('u');
        int[] prefix = new int[words.length + 1];
        int[] res = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            prefix[i + 1] = prefix[i] + (check(word) ? 1 : 0);
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            res[i] = prefix[query[1] + 1] - prefix[query[0]];
        }
        return res;
    }

    private boolean check(String word) {
        return set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1));
    }

}
