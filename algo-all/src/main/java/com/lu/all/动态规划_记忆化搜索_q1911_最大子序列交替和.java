package com.lu.all;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-11
 */
public class 动态规划_记忆化搜索_q1911_最大子序列交替和 {

    @Test
    public void test() {
        System.out.println(maxAlternatingSum(new int[]{4, 2, 5, 3}));
    }

    private int[] nums;
    private long[][] memo;

    public long maxAlternatingSum(int[] nums) {
        this.memo = new long[nums.length][2];
        for (long[] ints : this.memo) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        this.nums = nums;
        return dfs(0, 0);
    }

    private long dfs(int index, int minus) {
        if (index == nums.length) {
            return 0;
        }
        if (memo[index][minus] != Integer.MIN_VALUE) {
            return memo[index][minus];
        }
        long ans = dfs(index + 1, minus);
        ans = Math.max(ans, dfs(index + 1, minus ^ 1) + nums[index] * (1 - 2L * minus));
        return memo[index][minus] = ans;
    }


//    private int[] nums;
//    private long[][] memo;
//
//    public long maxAlternatingSum(int[] nums) {
//        this.memo = new long[nums.length][2];
//        for (long[] ints : memo) {
//            Arrays.fill(ints, Integer.MIN_VALUE);
//        }
//        this.nums = nums;
//        long res = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            res = Math.max(res, dfs(i, 0));
//        }
//        return res;
//    }
//
//    private long dfs(int index, int minus) {
//        if (memo[index][minus] != Integer.MIN_VALUE) {
//            return memo[index][minus];
//        }
//        int cur = nums[index] * (1 - 2 * minus);
//        if (index == nums.length - 1) {
//            return cur;
//        }
//
//        long res = cur;
//        for (int i = index + 1; i < nums.length; i++) {
//            res = Math.max(res, cur + dfs(i, minus ^ 1));
//        }
//        return memo[index][minus] = res;
//    }

}
