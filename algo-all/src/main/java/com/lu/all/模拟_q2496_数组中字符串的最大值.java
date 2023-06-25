package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-25
 */
public class 模拟_q2496_数组中字符串的最大值 {

    @Test
    public void test() {

    }

    public int maximumValue(String[] strs) {
        int res = 0;
        for (String str : strs) {
            int cur = 0;
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    cur = str.length();
                    break;
                }
            }
            if (cur == 0) {
                cur = Integer.parseInt(str);
            }
            res = Math.max(res, cur);
        }
        return res;
    }

}
