package com.lu.all;

import org.junit.Test;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author sheldon
 * @date 2022-12-03
 */
public class rev_q1796 {

    @Test
    public void test() {
        System.out.println(secondHighest1("dfa12321afd"));
    }

    public int secondHighest1(String s) {
        int first = -1;
        int second = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                int n = c - 48;
                if (n > first) {
                    if (first != -1) {
                        second = first;
                    }
                    first = n;
                } else if (n > second && n != first) {
                    second = n;
                }
            }
        }
        return second;
    }

    public int secondHighest(String s) {
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                set.add(c - 48);
            }
        }
        Integer integer = set.pollLast();
        if (integer == null) {
            return -1;
        }
        Integer integer1 = set.pollLast();
        return integer1 == null ? -1 : integer1;
    }

}
