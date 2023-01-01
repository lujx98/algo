package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-01
 */
public class q2351_1_模拟_位运算 {

    @Test
    public void test(){
        System.out.println(repeatedCharacter("abccbaacz"));
    }

    public char repeatedCharacter(String s) {
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((mask >> (c - 'a') & 1) == 1) {
                return c;
            }
            mask |= (1 << (c - 'a'));
        }
        return 0;
    }

}
