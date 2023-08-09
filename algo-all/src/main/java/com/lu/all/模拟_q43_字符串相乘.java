package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author sheldon
 * @date 2023-08-09
 */
public class 模拟_q43_字符串相乘 {

    @Test
    public void test() {
        System.out.println(multiply("498828660196"
                , "840477629533"
        ));
    }

    public String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        }
        String[] strings = new String[num2.length()];
        int zeroCount = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            strings[i] = multi(num1, (num2.charAt(i) - '0'), zeroCount);
            zeroCount++;
        }

        String res = strings[0];
        for (int i = 1; i < strings.length; i++) {
            res = add(res, strings[i]);
        }
        return res;
    }

    private String add(String string, String res) {
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int incurment = 0;
        while (index < string.length() || index < res.length()) {
            int cur = incurment;
            incurment = 0;
            if (string.length() - 1 - index >= 0) {
                cur += string.charAt(string.length() - 1 - index) - '0';
            }
            if (res.length() - 1 - index >= 0) {
                cur += res.charAt(res.length() - 1 - index) - '0';
            }
            if (cur >= 10) {
                cur -= 10;
                incurment = 1;
            }
            stringBuilder.insert(0, cur);
            index++;
        }
        if (incurment == 1) {
            stringBuilder.insert(0, 1);
        }
        return stringBuilder.toString();
    }

    private String multi(String num1, int time, int zeroCount) {
        StringBuilder stringBuilder = new StringBuilder();
        int add = 0;
        for (int i = num1.length() - 1; add != 0 || (i >= 0); i--) {
            if (i < 0) {
                int cur = add;
                add = cur / 10;
                stringBuilder.insert(0, cur);
                continue;
            }
            int cur = add + (num1.charAt(i) - '0') * time;
            add = cur / 10;
            cur %= 10;
            stringBuilder.insert(0, cur);
        }
        for (int i = 0; i < zeroCount; i++) {
            stringBuilder.append('0');
        }
        return stringBuilder.toString();
    }

}
