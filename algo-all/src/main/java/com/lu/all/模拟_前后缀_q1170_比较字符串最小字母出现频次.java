package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-10
 */
public class 模拟_前后缀_q1170_比较字符串最小字母出现频次 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"}, new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"})));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] prefix = new int[11];
        for (String word : words) {
            prefix[f(word)]++;
        }

        for (int i = prefix.length - 2; i >= 0; i--) {
            prefix[i] = prefix[i] + prefix[i + 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int f = f(queries[i]);
            res[i] = prefix[f + 1];
        }
        return res;
    }

    private int f(String str) {
        char cur = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < cur) {
                count = 1;
                cur = c;
            } else if (c == cur) {
                count++;
            }
        }
        return count;
    }

}
