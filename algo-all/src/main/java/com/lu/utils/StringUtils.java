package com.lu.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-04-08
 */
public class StringUtils {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(parse2DArray("[[],[],[],[],[\"jgpzzicdvgxlfix\"],[\"jgpzzicdvgxlfix\",\"k\"],[\"jgpzzicdvgxlfix\",\"kqcrfwerywbwi\"],[\"gvp\"],[\"jzukdzrfgvdbrunw\"],[\"gvp\",\"kqcrfwerywbwi\"]]")));
    }

    public static String[][] parse2DArray(String str) {
        String substring = str.substring(1, str.length() - 1);
        List<String[]> list = new ArrayList<>();
        char[] chars = substring.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(chars[i]);
                while (chars[i] != ']') {
                    i++;
                    stringBuilder.append(chars[i]);
                }
                String substring1 = stringBuilder.toString();
                if (substring1.length() == 2) {
                    list.add(new String[]{});
                    continue;
                }
                String substring2 = substring1.substring(1, substring1.length() - 1);
                substring2 = substring2.replace("\"", "");
                String[] split = substring2.split(",");
                list.add(split);
            }
        }

        String[][] strings = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            strings[i] = list.get(i);
        }
        return strings;
    }

    public static String[] parseArray(String str) {
        String substring = str.substring(1, str.length() - 1);
        String[] split = substring.split(",");
        return split;
    }

}
