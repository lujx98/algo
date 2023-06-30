package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-30
 */
public class q2746 {

    private int[][] memo;

    public int minimizeConcatenatedLength(String[] words) {
        this.memo = new int[words.length][26];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        int res = words.length - 1;
        res += dfs(1, words[0].charAt(0), words[0].charAt(words[0]  .length() - 1));
        return res;
    }

    private int dfs(int i, char headChar, char tailChar) {
//        if (memo[i][charAt - 'a'] != -1) {
//            return memo[i][charAt - 'a'];
//        }
//        int res = Math.min(dfs(, ), dfs(, ))
        return 0;
    }

}
