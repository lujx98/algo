package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-31
 */
public class 模拟_双指针_q1754 {

    @Test
    public void test() {
        System.out.println(largestMerge("cabaa", "bcaaa"));
    }

    public String largestMerge(String word1, String word2) {
        int right = 0, left = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (left < word1.length() || right < word2.length()) {
            if (right == word2.length() ||
                    (left < word1.length() && word1.substring(left).compareTo(word2.substring(right)) > 0)) {
                stringBuilder.append(word1.charAt(left));
                left++;
            } else {
                stringBuilder.append(word2.charAt(right));
                right++;
            }
        }
        return stringBuilder.toString();
    }

}
