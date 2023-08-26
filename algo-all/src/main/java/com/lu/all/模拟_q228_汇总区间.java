package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-08-26
 */
public class 模拟_q228_汇总区间 {

    @Test
    public void test() {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }

    public List<String> summaryRanges(int[] nums) {
        int left = 0, right = 0;
        List<String> res = new ArrayList<>();
        while (left < nums.length && right < nums.length) {
            while (right < nums.length - 1 && nums[right + 1] - nums[right] == 1) {
                right++;
            }
            if (left == right) {
                res.add(String.valueOf(nums[right]));
            } else {
                res.add(nums[left] + "->" + nums[right]);
            }
            left = right + 1;
            right = left;
        }
        return res;
    }

}
