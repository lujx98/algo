package com.lu.contest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class bc4 {

    @Test
    public void test() {
        System.out.println();
    }

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Arrays.sort(count);
        int target = 0;
        for (int i = count.length - 1; i >= count.length - k; i--) {
            target += count[i];
        }
        return 0;
    }

    private int dfs(int i, int target) {
        return 0;
    }

}
