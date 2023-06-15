package com.lu.all;

import com.lu.utils.ArraysUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-06-15
 */
public class rev_前后缀_q1177_构建回文串检测 {

    @Test
    public void test() {
        System.out.println(canMakePaliQueries("abcda", ArraysUtils.makeIntArraysByString("[[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]")));
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(check(s.substring(query[0], query[1] + 1), query[2]));
        }
        return res;
    }

    private Boolean check(String substring, int i) {
        if (substring.length() == 1) {
            return true;
        }
        int offset = 0;
        boolean[] booleans = new boolean[26];
        for (char c : substring.toCharArray()) {
            if (booleans[c - 'a']) {
                offset++;
                booleans[c - 'a'] = false;
            } else {
                booleans[c - 'a'] = true;
            }
        }
        return i >= ((substring.length() - offset * 2)) / 2;
    }

}
