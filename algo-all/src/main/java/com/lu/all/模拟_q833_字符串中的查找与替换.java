package com.lu.all;

import org.junit.Test;

import java.net.BindException;
import java.util.HashMap;

/**
 * @author sheldon
 * @date 2023-08-15
 */
public class 模拟_q833_字符串中的查找与替换 {

    @Test
    public void test() {
        System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        boolean[] match = new boolean[indices.length];
        for (int i = 0; i < indices.length; i++) {
            if (s.startsWith(sources[i], indices[i])) {
                match[i] = true;
            }
        }
        HashMap<Integer, String> indexMap = new HashMap<>();
        HashMap<Integer, String> targetMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            if (match[i]) {
                indexMap.put(indices[i], sources[i]);
                targetMap.put(indices[i], targets[i]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            String s1 = indexMap.get(i);
            if (s1 != null) {
                stringBuilder.append(targetMap.get(i));
                i += s1.length();
            } else {
                stringBuilder.append(s.charAt(i));
                i++;
            }
        }

        return stringBuilder.toString();
    }

}
