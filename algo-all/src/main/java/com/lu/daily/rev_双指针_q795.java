package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-11-24
 */
public class rev_双指针_q795 {

    @Test
    public void test() {
        System.out.println(numSubarrayBoundedMax1(new int[]{2, 9, 2, 5, 6}, 2, 8));
    }

    public int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        int l = -1,r = -1,ans =0 ;
        for (int rightPtr = 0; rightPtr < nums.length; rightPtr++) {
            if (nums[rightPtr] > right) {
                l = rightPtr;
            }
            if (nums[rightPtr] >= left) {
                r = rightPtr;
            }
            ans += r-l;
        }
        return ans;
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0] <= right && nums[0] >= left ? 1 : 0;
        int k = (nums[0] >= left) ? 0 : -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > right) {
                dp[i] = 0;
            } else if (nums[i] < left) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + (i - k - 1) + 1;
            }
            if (nums[i] >= left) {
                k = i;
            }

        }
        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }

}
