package com.lu.all;

/**
 * @author sheldon
 * @date 2023-06-30
 */
public class 模拟_q2490_回环句 {

    public boolean isCircularSentence(String sentence) {
        boolean flag = false;
        for (int i = 0; i < sentence.toCharArray().length; i++) {
            if (sentence.charAt(i) == ' ') {
                flag = true;
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }
        if (!flag) {
            return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
        } else {
            return true;
        }
    }

}
