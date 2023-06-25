package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-25
 */
public class q6910 {

    @Test
    public void test() {
        System.out.println(numberOfGoodSubarraySplits(new int[]{}));
    }

    private final static int MOD = 1000000007;
    private int[] memo;

    public int numberOfGoodSubarraySplits(int[] nums) {
        this.memo = new int[nums.length];
        Arrays.fill(memo, -2);
        long res = 0;
        boolean containOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (containOne) {
                    break;
                } else {
                    containOne = true;
                }
            }
            if (containOne) {
                int dfs = memo[i] = (dfs(nums, i) % MOD);
                if (dfs != -1) {
                    res = (res + dfs) % MOD;
                }
            }
        }
        return (int)res;
    }

    private int dfs(int[] nums, int index) {
        if (index == nums.length - 1) {
            return 1;
        }
        if (memo[index] != -2) {
            return memo[index];
        }
        long res = 0;
        boolean containOne = false;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (containOne) {
                    break;
                } else {
                    containOne = true;
                }
            }
            if (containOne) {
                int dfs = memo[i] = dfs(nums, i) % MOD;
                if (dfs != -1) {
                    res = (res + dfs) % MOD;
                }
            }
        }
        return (int)(res == 0 ? -1 : res % MOD);
    }

}
