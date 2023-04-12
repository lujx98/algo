package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-12
 */
public class 模拟_贪心_q1147_段式回文 {

    private String text;

    @Test
    public void test() {
        System.out.println(longestDecomposition("aaa"));
    }

    public int longestDecomposition(String text) {
        if (text.isEmpty())
            return 0;
        for (int i = 1, n = text.length(); i <= n / 2; ++i) // 枚举前后缀长度
            if (text.substring(0, i).equals(text.substring(n - i))) // 立刻分割
                return 2 + longestDecomposition(text.substring(i, n - i));
        return 1; // 无法分割
    }

}
