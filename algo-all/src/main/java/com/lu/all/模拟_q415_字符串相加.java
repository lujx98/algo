package com.lu.all;

/**
 * @author sheldon
 * @date 2023-07-17
 */
public class 模拟_q415_字符串相加 {

    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        String res = "";
        boolean over = false;
        while (index1 >= 0 || index2 >= 0) {
            int cur = 0;
            if (index1 >= 0) {
                cur += (num1.charAt(index1) - '0');
            }
            if (index2 >= 0) {
                cur += (num1.charAt(index2) - '0');
            }
            cur += over ? 1 : 0;
            over = false;
            if (cur >= 10) {
                cur -= 10;
                over = true;
            }
            res = cur + res;
            index1--;
            index2--;
        }
        if (over) {
            res = "1" + res;
        }
        return res;
    }

}
