package com.lu.contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class bc2 {

    @Test
    public void test() {
        System.out.println();
    }

    public boolean checkStrings(String s1, String s2) {
        List<Integer> s1O = new ArrayList<>();
        for (int i = 0; i < s1.length(); i += 2) {
            s1O.add(s1.charAt(i) - '0');
        }
        s1O.sort(Integer::compareTo);
        List<Integer> s2O = new ArrayList<>();
        for (int i = 0; i < s2.length(); i += 2) {
            s2O.add(s2.charAt(i) - '0');
        }
        s2O.sort(Integer::compareTo);
        if (!s1O.equals(s2O)) {
            return false;
        }

        List<Integer> s1A = new ArrayList<>();
        for (int i = 1; i < s1.length(); i += 2) {
            s1A.add(s1.charAt(i) - '0');
        }
        s1A.sort(Integer::compareTo);

        List<Integer> s2A = new ArrayList<>();
        for (int i = 1; i < s2.length(); i += 2) {
            s2A.add(s2.charAt(i) - '0');
        }
        s2A.sort(Integer::compareTo);
        return s1A.equals(s2A);
    }

}
