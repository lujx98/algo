package com.lu.daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-01-12
 */
public class q1807_模拟 {

    @Test
    public void test() {
        List<String> objects = new ArrayList<>();
        objects.add("a");
        objects.add("yes");
        List<List<String>> objects1 = new ArrayList<>();
        objects1.add(objects);
        System.out.println(evaluate("(a)(a)(a)aaa", objects1));
    }

    private final static String A = "?";

    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }
        knowledge = null;
        int left = 0, right = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (; right < chars.length; right++) {
            left = right;
            if (chars[right] == '(') {
                while (chars[right] != ')') {
                    right++;
                }
                String substring = s.substring(left + 1, right);
                String s1 = map.get(substring);
                if (s1 != null) {
                    stringBuilder.append(s1);
                } else {
                    stringBuilder.append(A);
                }
            } else {
                stringBuilder.append(chars[right]);
            }
        }
        return stringBuilder.toString();
    }

}
