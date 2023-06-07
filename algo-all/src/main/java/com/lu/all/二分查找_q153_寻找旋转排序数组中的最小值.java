package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-06
 */
public class 二分查找_q153_寻找旋转排序数组中的最小值 {

    @Test
    public void test() {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }

    //        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if ( f(mid) <= f(target)  mid的位置在target之前注意不等于mid target在mid之后注意不等于mid  ) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return nums[left];

    public int findMin(int[] nums) {
        int right = nums.length - 1, left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

}


