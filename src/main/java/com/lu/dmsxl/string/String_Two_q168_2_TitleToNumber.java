package com.lu.dmsxl.string;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-19
 */
public class String_Two_q168_2_TitleToNumber {

    @Test
    public void test() {
        System.out.println(titleToNumber("AB"));
    }

    public int titleToNumber(String columnTitle) {
        int n = 0;
        int muti = 1;
        char[] chars = columnTitle.toCharArray();
        int length = chars.length;
        for (int i = chars.length - 1; i >= 0; i--) {
            n = n + (chars[i] - 'A'+1) * muti;
            muti *=26;
        }
        return n;
    }

}
