package com.lu.all;

/**
 * @author sheldon
 * @date 2023-06-30
 */
public class q2744 {

    public int maximumNumberOfStringPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String word = words[i];
                String word1 = words[j];
                if (word.charAt(0) == word1.charAt(1) && word.charAt(1) == word1.charAt(0)) {
                    res++;
                }
            }
        }
        return res;
    }

}
