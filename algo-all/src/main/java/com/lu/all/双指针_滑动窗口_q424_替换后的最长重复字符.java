package com.lu.all;

import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-07-07
 */
public class 双指针_滑动窗口_q424_替换后的最长重复字符 {

    public int characterReplacement(String s, int k) {
        HashSet<Character> uni = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            uni.add(s.charAt(i));
        }
        int res = 0;
        for (Character character : uni) {
            int otherCount = 0, curRes = 1;
            char cur = (char) character;
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                if (s.charAt(right) != cur) {
                    otherCount++;
                }
                if (otherCount > k) {
                    while (s.charAt(left) == cur) {
                        left++;
                    }
                    left++;
                    otherCount = k;
                }
                curRes = Math.max(curRes, right - left + 1);
            }
            res = Math.max(res, curRes);
        }
        return res;
    }

    public int characterReplacement1(String s, int k) {
        boolean[] booleans = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            booleans[s.charAt(i) - 'a'] = true;
        }
        int res = 0;
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                char cur = (char)(i + 'a');
                int otherCount = 0, curRes = 1;
                int left = 0;
                for (int right = 0; right < s.length(); right++) {
                    if (s.charAt(right) != cur) {
                        otherCount++;
                    }
                    if (otherCount > k) {
                        while (s.charAt(left) == cur) {
                            left++;
                        }
                        left++;
                        otherCount = k;
                    }
                    curRes = Math.max(curRes, right - left + 1);
                }
                res = Math.max(res, curRes);
            }
        }
        return res;
    }

}
