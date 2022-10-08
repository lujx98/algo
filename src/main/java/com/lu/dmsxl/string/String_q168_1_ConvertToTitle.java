package com.lu.dmsxl.string;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-19
 */
public class String_q168_1_ConvertToTitle {

    @Test
    public void test() {
        System.out.println(convertToTitle(28));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            stringBuilder.append((char) ('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        return stringBuilder.reverse().toString();
    }

}
