package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-05-14
 */
public class 前后缀分解_技巧题_q6369_最大或值 {

    @Test
    public void test() {
        maximumOr(new int[]{8, 1, 2}, 2);
    }

    public long maximumOr(int[] nums, int k) {
        //prefix[i] 表示nums[i] 之前所有数的总或 不包括i
        int[] prefix = new int[nums.length + 1];
        //suffix[i] 表示nums[i] 之后所有数的总或 不包括i
        int[] suffix = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] | nums[i];
        }
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] | nums[i];
            long temp = prefix[i] | suffix[i + 1];
            long cur = temp | ((long) nums[i] << k);
            res = Math.max(res, cur);
        }
        return res;
    }

}
