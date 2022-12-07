package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-07
 */
public class q1775_1_贪心 {

    @Test
    public void test(){
        System.out.println(minOperations(new int[]{6, 6}, new int[]{1}));
    }

    public int minOperations(int[] nums1, int[] nums2) {
        if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length)
            return -1; // 优化
        int diff = 0;
        for (int i : nums1) {
            diff += i;
        }
        for (int i : nums2) {
            diff -= i;
        }
        if (diff < 0) {
            diff = -diff;
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int[] dif = new int[6];
        for (int i : nums1) {
            ++dif[i-1];
        }
        for (int i : nums2) {
            ++dif[6-i];
        }
        for (int i = 5, ans = 0; ; --i) { // 从大到小枚举最大变化量 5 4 3 2 1
            if (i * dif[i] >= diff) // 可以让 d 变为 0
                return ans + (diff + i - 1) / i;
            ans += dif[i]; // 需要所有最大变化量为 i 的数
            diff -= i * dif[i];
        }
    }

}