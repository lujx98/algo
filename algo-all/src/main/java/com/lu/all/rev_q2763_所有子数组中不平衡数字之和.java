package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-07-02
 */
public class rev_q2763_所有子数组中不平衡数字之和 {

    @Test
    public void test() {
        System.out.println(sumImbalanceNumbers(new int[]{1, 3, 1}));
    }

    public int sumImbalanceNumbers(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }
        prefix[nums.length] = prefix[nums.length - 1];
        //prefix[i+1] 表示到i为止包括i      i到j有多少个：prefix[j] - prefix[i-1]
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res += (prefix[j + 1] - prefix[i]);
            }
        }
        return res;
    }

}
