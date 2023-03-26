package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-06
 */
public class 前缀后缀_优化技巧_q1653 {

    @Test
    public void test() {
        System.out.println(minimumDeletions("bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba"));
    }

    public int minimumDeletions(String s) {
        int curCount = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'a') {
                curCount++;
            }
        }
        if (curCount == s.length() || curCount == 0) {
            return 0;
        }
        int minCount = curCount;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                curCount--;
            } else {
                curCount++;
            }
            minCount = Math.min(curCount, minCount);
        }
        return minCount;
    }

}