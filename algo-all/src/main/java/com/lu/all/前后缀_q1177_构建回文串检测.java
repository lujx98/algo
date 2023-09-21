package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-09-21
 */
public class 前后缀_q1177_构建回文串检测 {

    @Test
    public void test() {
        System.out.println(canMakePaliQueries("abcda", ArrayUtils.makeIntArraysByString("[[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]")));
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] prefixs = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < prefixs.length; j++) {
                prefixs[j][i + 1] = prefixs[j][i] + (s.charAt(i) - 'a' == j ? 1 : 0);
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int cur = 0;
            for (int[] prefix : prefixs) {
                int curDif = prefix[query[1] + 1] - prefix[query[0]];
                if (curDif % 2 == 1) {
                    cur++;
                }
            }
            res.add((cur - 2 * query[2]) <= 1);
        }
        return res;
    }

}
