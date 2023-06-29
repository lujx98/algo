package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-25
 */
public class 说不出来_q6910_将数组划分成若干好子数组的方式 {

    @Test
    public void test() {
        System.out.println(numberOfGoodSubarraySplits(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0}));
    }

    public int numberOfGoodSubarraySplits(int[] nums) {
        long res = 1;
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] != 1) {
                i++;
            }
            if (i == nums.length) {
                break;
            }
            if (pre != -1) {
                res = ((res * (i - pre) % 1000000007) % 1000000007) % 1000000007;
            }
            pre = i;
        }
        return pre == -1 ? 0 : (int) res;
    }

//
//    private final static int MOD = 1000000007;
//    private int[] memo;
//
//    public int numberOfGoodSubarraySplits(int[] nums) {
//        this.memo = new int[nums.length];
//        Arrays.fill(memo, -2);
//        long res = 0;
//        boolean containOne = false;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                if (containOne) {
//                    break;
//                } else {
//                    containOne = true;
//                }
//            }
//            if (containOne) {
//                int dfs = memo[i] = (dfs(nums, i) % MOD);
//                if (dfs != -1) {
//                    res = (res + dfs) % MOD;
//                }
//            }
//        }
//        return (int)res;
//    }
//
//    private int dfs(int[] nums, int index) {
//        if (index == nums.length - 1) {
//            return 1;
//        }
//        if (memo[index] != -2) {
//            return memo[index];
//        }
//        long res = 0;
//        boolean containOne = false;
//        for (int i = index + 1; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                if (containOne) {
//                    break;
//                } else {
//                    containOne = true;
//                }
//            }
//            if (containOne) {
//                int dfs = memo[i] = dfs(nums, i) % MOD;
//                if (dfs != -1) {
//                    res = (res + dfs) % MOD;
//                }
//            }
//        }
//        return (int)(res == 0 ? -1 : res % MOD);
//    }

}
