package com.lu.all;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sheldon
 * @date 2023-06-19
 */
public class 动态规划_记忆化搜索_q1262_可被三整除的最大和 {

    @Test
    public void test() {
        System.out.println(maxSumDivThree(new int[]{366, 809, 6, 792, 822, 181, 210, 588, 344, 618, 341, 410, 121, 864, 191, 749, 637, 169, 123, 472, 358, 908, 235, 914, 322, 946, 738, 754, 908, 272, 267, 326, 587, 267, 803, 281, 586, 707, 94, 627, 724, 469, 568, 57, 103, 984, 787, 552, 14, 545, 866, 494, 263, 157, 479, 823, 835, 100, 495, 773, 729, 921, 348, 871, 91, 386, 183, 979, 716, 806, 639, 290, 612, 322, 289, 910, 484, 300, 195, 546, 499, 213, 8, 623, 490, 473, 603, 721, 793, 418, 551, 331, 598, 670, 960, 483, 154, 317, 834, 352}));
    }

    public int[] nums;
    public int[][] memo;

    public int maxSumDivThree(int[] nums) {
        this.nums = nums;
        this.memo = new int[nums.length][3];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, 0);
    }

    private int dfs(int index, int mod) {
        if (index == nums.length) {
            return mod == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[index][mod] != -1) {
            return memo[index][mod];
        }
        return memo[index][mod] = Math.max(dfs(index + 1, mod), dfs(index + 1, (mod + nums[index]) % 3) + nums[index]);
    }

}
