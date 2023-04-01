package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-29
 */
public class 模拟_q2315 {

    @Test
    public void test(){

    }

    public int countAsterisks(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c =='|'){
                i++;
                while (chars[i]!='|'){
                    i++;
                }
            }else if (c=='*'){
                count++;
            }
        }
        return count;
    }

}
