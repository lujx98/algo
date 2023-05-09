package com.lu.all;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2023-04-22
 */
public class rev_q1027 {

    private Map<Integer, Integer>[] memo;
    private int[] nums;

    public int longestArithSeqLength(int[] nums) {
        this.nums = nums;
        memo = new HashMap[nums.length];
        Arrays.setAll(memo, e -> new HashMap<Integer, Integer>());
        return dfs(nums.length, -1);
    }

    private int dfs(int index, int dif) {
        if (memo[index].containsKey(dif)) {
            return memo[index].get(dif);
        }

        return 0;
    }

}
