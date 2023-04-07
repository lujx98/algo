package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-01-28
 */
public class rev_前后缀数组_模拟_q1664 {

    @Test
    public void test() {
        System.out.println(waysToMakeFair(new int[]{2, 1, 6, 4}));
    }

    public int waysToMakeFair(int[] nums) {
        if (nums.length == 2) {
            return nums[1] == nums[0] ? 1 : 0;
        }
        if (nums.length == 1) {
            return 0 == nums[0] ? 1 : 0;
        }
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = nums[0];
        prefix[1] = nums[1];
        suffix[nums.length - 1] = nums[nums.length - 1];
        suffix[nums.length - 2] = nums[nums.length - 2];
        int sum = nums[0] + nums[1];
        for (int i = 2; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 2];
            sum += nums[i];
        }
        for (int i = nums.length - 3; i >= 0; i--) {
            suffix[i] = nums[i] + suffix[i + 2];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((sum - nums[i]) % 2 != 0) {
                continue;
            }
            int postSame = i + 1 > nums.length - 1 ? 0 : suffix[i + 1];
            int postDif = i + 2 > nums.length - 1 ? 0 : suffix[i + 2];
            int preDif = i - 1 < 0 ? 0 : prefix[i - 1];
            int preSame = i - 2 < 0 ? 0 : prefix[i - 2];
            if (preDif + postDif == preSame + postSame) {
                count++;
            }
        }
        return count;
    }

}
