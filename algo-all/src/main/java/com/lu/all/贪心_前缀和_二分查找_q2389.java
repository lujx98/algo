package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-03-17
 */
public class 贪心_前缀和_二分查找_q2389 {

    @Test
    public void test(){
        System.out.println(Arrays.toString(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
    }

    public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }

            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                //  二分查找优化
                for (int j = 0; j < nums.length; j++) {
                    if (queries[i] < nums[j]) {
                        res[i] = j;
                        break;
                    }
                    if (j == nums.length - 1) {
                        res[i] = nums.length;
                    }
                }
            }
            return res;
    }

}
