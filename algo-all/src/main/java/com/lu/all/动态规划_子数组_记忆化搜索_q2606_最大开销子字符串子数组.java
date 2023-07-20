package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2023-07-20
 */
public class 动态规划_子数组_记忆化搜索_q2606_最大开销子字符串子数组 {

    @Test
    public void test() {
        System.out.println(maximumCostSubstring("adaa", "d", new int[]{-1000}));
    }

    private final int[] costMap = new int[26];
    private String s;
    private int[] memo;

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        this.s = s;
        this.memo = new int[s.length()];
        Arrays.fill(memo, Integer.MIN_VALUE);
        for (int i = 0; i < costMap.length; i++) {
            costMap[i] = i + 1;
        }
        for (int i = 0; i < chars.length(); i++) {
            costMap[chars.charAt(i) - 'a'] = vals[i];
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = Math.max(res, dfs(i));
        }
        return res;
    }

    private int dfs(int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != Integer.MIN_VALUE) {
            return memo[i];
        }
        return memo[i] = Math.max(costMap[s.charAt(i) - 'a'], costMap[s.charAt(i) - 'a'] + dfs(i - 1));
    }

}
