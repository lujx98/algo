package com.lu.daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 *
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 *
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 *
 *
 *
 * 示例 1:
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 示例 2:
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * 示例 3:
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * 示例 4:
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 *
 * @author sheldon
 * @date 2022-11-07
 */
public class rev_q816 {

    @Test
    public void test() {
        System.out.println(ambiguousCoordinates("(123)"));
    }

    private final List<String> returnList = new ArrayList<>();

    public List<String> ambiguousCoordinates(String s) {
        String substring = s.substring(1, s.length() - 1);
        for (int i = 1; i < substring.length(); i++) {
            List<String> left = getCoordinates(substring.substring(0, i));
            if (left.isEmpty()) {
                continue;
            }

            List<String> right = getCoordinates(substring.substring(i));
            if (right.isEmpty()) {
                continue;
            }
            for (String s1 : left) {
                for (String s2 : right) {
                    returnList.add("(" + s1 + ", " + s2 + ")");
                }
            }

        }
        return returnList;
    }

    private List<String> getCoordinates(String substring) {
        List<String> objects = new ArrayList<>();
        if (!substring.startsWith("0")) {
            objects.add(substring);
        }
        if ("0".equals(substring)) {
            objects.add(substring);
            return objects;
        }
        for (int i = 1; i < substring.length(); i++) {
            if (substring.endsWith("0") ||
                    (i != 1 && substring.charAt(0) == '0')) {
                continue;
            }
            objects.add(substring.substring(0, i) + '.' + substring.substring(i));
        }
        return objects;
    }

}
