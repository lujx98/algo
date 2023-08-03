package com.lu.all;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author sheldon
 * @date 2023-08-03
 */
public class 模拟_q722_删除注释 {

    @Test
    public void test() {
        System.out.println(removeComments(new String[]{"a/*/b//*c","blank","d/*/e*//f"}));
    }

    public List<String> removeComments(String[] source) {
        List<String> objects = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            int splashIndex = source[i].indexOf("//");
            int blockCommentIndex = source[i].indexOf("/*");
            if (splashIndex != -1 || blockCommentIndex != -1) {
                if (splashIndex != -1 && (blockCommentIndex == -1 || splashIndex < blockCommentIndex)) {
                    if (splashIndex != 0) {
                        objects.add(source[i].substring(0, splashIndex));
                    }
                } else {
                    source[i] = source[i].replaceAll("/[*].*[*]/", "");
                    blockCommentIndex = source[i].indexOf("/*");
                    if (blockCommentIndex != -1) {
                        source[i] = source[i].substring(0, blockCommentIndex);
                        String pre = source[i];
                        while (!source[i].contains("*/")) {
                            i++;
                        }
                        int beginIndex = source[i].indexOf("*/") + 2;
                        String s = pre + source[i].substring(beginIndex);
                        if (s.length() != 0) {
                            objects.add(s);
                        }
                    } else if (source[i].length() != 0) {
                        objects.add(source[i]);
                    }
                }
            } else {
                objects.add(source[i]);
            }
        }
        return objects;
    }

}
