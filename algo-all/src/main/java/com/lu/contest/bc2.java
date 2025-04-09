package com.lu.contest;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class bc2 {

    @Test
    public void test() {
        System.out.println();
    }

    public int minChanges(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                res++;
            }
        }
        return res;
    }

}
