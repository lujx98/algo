package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-26
 */
public class 双指针_q1004 {

    @Test
    public void test(){
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0, zCount = 0, count = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            count += num;
            if (num == 0) {
                zCount++;
            }
            while (zCount > k) {
                if (nums[left] == 0) {
                    zCount--;
                }
                count -= nums[left++];
            }
            ans = Math.max(ans, (right - left + 1));
        }
        return ans;
    }

}
