package com.lu.dmsxl.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-10-06
 */
public class GRE_q455_1_FindContentChildren {

    @Test
    public void test() {
        System.out.println(findContentChildren(new int[]{2, 3},
                new int[]{1, 1, 3}));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = 0;
        for (int i = 0; i < s.length && index < g.length; i++) {
            if (s[i] >= g[index]) {
                index++;
                count++;
            }
        }
        return count;
    }
}
