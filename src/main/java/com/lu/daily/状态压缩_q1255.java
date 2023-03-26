package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-26
 */
public class 状态压缩_q1255 {

    @Test
    public void test(){
        maxScoreWords(new String[]{"dog","cat","dad","good"},new char[]{'a','a','c','d','d','d','g','o','o'},new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0});
    }

    @Test
    public void test2(){
        int i = 1 << 2;
        System.out.println((i & 12) == 1);
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int[] wordCount = new int[26];
        for (char letter : letters) {
            wordCount[letter - 'a']++;
        }
        int res = 0;
        for (int i = 1; i < (1 << n); i++) {
            int[] groupCount = new int[26];
            int groupScore = 0;
            for (int j = 0; j < words.length; j++) {
                if (((i >> j) & 1) == 1) {
                    String word = words[j];
                    for (char c : word.toCharArray()) {
                        groupCount[c - 'a']++;
                        groupScore += score[c - 'a'];
                    }
                }
            }

            //校验合法性
            boolean pass = true;

            for (int j = 0; j < 26; j++) {
                if (groupCount[j] > wordCount[j]) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                res = Math.max(res, groupScore);
            }
        }
        return res;
    }

}
