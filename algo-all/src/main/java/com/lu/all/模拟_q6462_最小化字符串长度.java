package com.lu.all;

import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-06-04
 */
public class 模拟_q6462_最小化字符串长度 {

    public int minimizedStringLength(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

}
