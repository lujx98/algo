package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-13
 */
public class q1832_1_位运算 {

    @Test
    public void test(){
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }

    public boolean checkIfPangram(String sentence) {
        int mask = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            mask |= (1 << (c - 'a'));
        }
        return mask == ((1 << 26) - 1);
    }

}
