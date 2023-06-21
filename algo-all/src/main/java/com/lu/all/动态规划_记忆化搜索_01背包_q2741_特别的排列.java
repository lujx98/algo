package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2023-06-20
 */
public class 动态规划_记忆化搜索_01背包_q2741_特别的排列 {

    @Test
    public void test() {
        System.out.println(1278945280 % MOD);
        System.out.println(specialPerm(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192}));
    }

    private int[] nums;
    private final Map<Integer, int[]> memo = new HashMap<>();
    private static final int MOD = (int) 1e9 + 7;

    public int specialPerm(int[] nums) {
        this.nums = nums;
        int res = 0;
        int mask = 0;
        for (int i = 0; i < nums.length; i++) {
            res = (res + dfs(mask | (1 << i), i) % MOD) % MOD;
        }
        return res;
    }

    private int dfs(int mask, int prev) {
        if (mask == (1 << nums.length) - 1) {
            return 1;
        }
        if (memo.containsKey(mask)) {
            int[] ints = memo.get(mask);
            if (ints[prev] != -1) {
                return ints[prev];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }
            if (nums[i] % nums[prev] == 0 || nums[prev] % nums[i] == 0) {
                res = (res + dfs(mask | (1 << i), i) % MOD) % MOD;
            }
        }
        res = res % MOD;
        int[] ints = memo.get(mask);
        if (ints != null) {
            ints[prev] = res;
        } else {
            int[] ints1 = new int[14];
            Arrays.fill(ints1, -1);
            ints1[prev] = res;
            memo.put(mask, ints1);
        }
        return res;
    }

}
