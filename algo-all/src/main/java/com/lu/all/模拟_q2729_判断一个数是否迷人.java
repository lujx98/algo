package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-07-07
 */
public class 模拟_q2729_判断一个数是否迷人 {

    @Test
    public void test() {
        System.out.println(isFascinating(783));
    }

    public boolean isFascinating(int n) {
        String s = String.valueOf(n) + String.valueOf(2 * n) + String.valueOf(3 * n);
        if (s.length() != 9) {
            return false;
        }
        char[] chars = s.toCharArray();
        int mask = 0;
        for (char aChar : chars) {
            mask |= (1 << (aChar - '1'));
        }
        int a = ((1 << 9) - 1);
        return mask == a;
    }

}
