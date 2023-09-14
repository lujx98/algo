package com.lu.all;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author sheldon
 * @date 2023-09-10
 */
public class 双指针_q2516_每种字符至少取K个 {

    @Test
    public void test() {
        System.out.println(takeCharacters("cbbac", 1));
    }

    public int takeCharacters(String s, int k) {
        int left = 0, right = s.length();

        HashMap<Character, Integer> count = new HashMap<>();
        count.put('a', 0);
        count.put('b', 0);
        count.put('c', 0);

        while (check(count, k)) {
            if (right <= 0) {
                return -1;
            }
            count.merge(s.charAt(--right), 1, Integer::sum);
        }
        int res = s.length() - right;

        for (; right < s.length(); ) {
            while (left < right && !check(count, k)) {
                left++;
                count.merge(s.charAt(left), 1, Integer::sum);
            }
            res = Math.min(res, (left + 1) + (s.length() - right));
            count.merge(s.charAt(right), 1, Integer::sum);
            right++;
        }

        return res;
    }

    private boolean check(Map<Character, Integer> map, int k) {
        for (Integer value : map.values()) {
            if (value < k) {
                return false;
            }
        }
        return true;
    }

}
