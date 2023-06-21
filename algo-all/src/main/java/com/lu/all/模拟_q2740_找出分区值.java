package com.lu.all;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-20
 */
public class 模拟_q2740_找出分区值 {

    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            res = Math.min(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

}
