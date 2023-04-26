package com.lu.all;

import com.fasterxml.jackson.core.JsonToken;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-04-26
 */
public class 动态规划_记忆化搜索_前缀和优化_q1031_两个非重叠子数组的最大和 {

    @Test
    public void test() {
        System.out.println(Arrays.stream(new int[]{87, 42, 40, 86, 93, 4, 18, 28, 59, 30, 99}).sum());
        System.out.println(maxSumTwoNoOverlap(new int[]{87, 42, 40, 86, 93, 4, 18, 28, 59, 30, 6, 51, 99, 46, 40, 24, 19, 98, 40, 41}, 1, 10));
    }

    private int firstLen, secondLen;
    private int[] nums;
    private int[][] memo;

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        this.firstLen = firstLen;
        this.secondLen = secondLen;
        this.nums = nums;
        this.memo = new int[nums.length][nums.length];
        return dfs(0, nums.length - 1);
    }

    private int dfs(int head, int tail) {
        if (head + firstLen > nums.length || tail - secondLen + 1 < 0) {
            return Integer.MIN_VALUE;
        }
        if (memo[head][tail] != 0) {
            return memo[head][tail];
        }
        int res = 0;
        if (tail - head < (firstLen + secondLen - 1) && tail - head >= 0) {
            res = Integer.MIN_VALUE;
        } else {
            for (int i = 0; i < secondLen; i++) {
                res += nums[tail - i];
            }
            for (int i = 0; i < firstLen; i++) {
                res += nums[head + i];
            }
        }
        return memo[head][tail] = Math.max(res, Math.max(dfs(head + 1, tail), dfs(head, tail - 1)));
    }

}
