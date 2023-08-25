package com.lu.all;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-11
 */
public class 动态规划_线性dp_选还是不选_记忆化搜索_q1911_最大子序列交替和 {

    @Test
    public void test() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\新建文本文档 (4).txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s = reader.readLine();
        String[] split = s.split(",");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(ints));
        System.out.println(ints.length);
        split = null;
        System.out.println(maxAlternatingSum(ints));
    }

//    private int[] nums;
//    private long[][] memo;
//
//    public long maxAlternatingSum(int[] nums) {
//        this.memo = new long[nums.length][2];
//        for (long[] ints : this.memo) {
//            Arrays.fill(ints, Integer.MIN_VALUE);
//        }
//        this.nums = nums;
//        return dfs(0, 0);
//    }
//
//    private long dfs(int index, int minus) {
//        if (index == nums.length) {
//            return 0;
//        }
//        if (memo[index][minus] != Integer.MIN_VALUE) {
//            return memo[index][minus];
//        }
//        long ans = dfs(index + 1, minus);
//        ans = Math.max(ans, dfs(index + 1, minus ^ 1) + nums[index] * (1 - 2L * minus));
//        return memo[index][minus] = ans;
//    }
//      todo:为什么超时
    private int[] nums;
    private long[][] memo;

    public long maxAlternatingSum(int[] nums) {
        this.memo = new long[nums.length][2];
        for (long[] ints : memo) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        this.nums = nums;
        long res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(i, 0));
        }
        return res;
    }

    private long dfs(int index, int minus) {
        if (index == nums.length) {
            return 0;
        }
        int cur = nums[index] * (1 - 2 * minus);
        if (memo[index][minus] != Integer.MIN_VALUE) {
            return memo[index][minus];
        }

        long res = cur;
        int minus1 = minus ^ 1;
        for (int i = index + 1; i <= nums.length; i++) {
            res = Math.max(res, cur + dfs(i, minus1));
        }
        return memo[index][minus] = res;
    }

}
