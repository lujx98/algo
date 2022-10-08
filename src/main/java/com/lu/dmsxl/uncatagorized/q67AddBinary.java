package com.lu.dmsxl.uncatagorized;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-09-18
 */
public class q67AddBinary {

    @Test
    public void test() {
        System.out.println(addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            b = leftPad(b, a.length(), '0');
        } else {
            a = leftPad(a, b.length(), '0');
        }
        StringBuilder stringBuilder = new StringBuilder();
        Boolean need = false;
        for (int max = a.length() - 1; max >= 0; max--) {
            if (a.charAt(max) == '1' && b.charAt(max) == '1' && need) {
                stringBuilder.append('1');
            } else if (a.charAt(max) == '1' && b.charAt(max) == '1' && !need) {
                stringBuilder.append('0');
                need = true;
            } else if ((a.charAt(max) == '1' || b.charAt(max) == '1') && need) {
                stringBuilder.append('0');
            } else if ((a.charAt(max) == '1' || b.charAt(max) == '1') && !need) {
                stringBuilder.append('1');
            } else if (a.charAt(max) == '0' && b.charAt(max) == '0' && need) {
                stringBuilder.append('1');
                need = false;
            } else if (a.charAt(max) == '0' && b.charAt(max) == '0' && !need) {
                stringBuilder.append('0');
            }
            if (max == 0 && need) {
                stringBuilder.append('1');
            }
        }
        return stringBuilder.reverse().toString();
    }

    public String leftPad(String s, int minLength, char filling) {
        int ln = s.length();
        if (minLength <= ln) {
            return s;
        }

        StringBuilder res = new StringBuilder(minLength);

        int dif = minLength - ln;
        for (int i = 0; i < dif; i++) {
            res.append(filling);
        }

        res.append(s);

        return res.toString();
    }

}
