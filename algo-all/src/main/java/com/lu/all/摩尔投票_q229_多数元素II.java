package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-07-20
 */
public class 摩尔投票_q229_多数元素II {

    @Test
    public void test() {
        System.out.println(majorityElement(new int[]{0,3,4,0}));
    }
    //用摩尔投票来做没有很大意义
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 1) {
            return Collections.singletonList(nums[0]);
        }
        int res1 = nums[0];
        int res2 = nums[1];
        int count1 = 1;
        int count2 = 1;
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            if (num == res1) {
                count1++;
            } else if (num == res2) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                res1 = num;
            } else if (count2 == 0) {
                count1++;
                res2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == res1) {
                count1++;
            } else if (num == res2) {
                count2++;
            }
        }
        int th = (nums.length + 2) / 3;
        if (count1 > th) {
            res.add(res1);
        }
        if (count2 > th) {
            res.add(res2);
        }
        return res;
    }

}
