package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-28
 */
public class 贪心_q2027 {

    @Test
    public void test(){
        System.out.println(minimumMoves("XXOX"));
        System.out.println(minimumMoves("XXX"));
        System.out.println(minimumMoves("OOOO"));
    }

    public int minimumMoves(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                res++;
                i += 2;
            }
        }
        return res;
    }

}
