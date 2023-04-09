package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-04-09
 */
public class 模拟_q2399_检查相同字母间的距离 {

    public boolean checkDistances(String s, int[] distance) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (alpha[index] == -1) {
                alpha[index] = i;
            } else if (i - alpha[index] - 1 != distance[index]) {
                return false;
            }
        }
        return true;
    }

}
