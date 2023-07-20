package com.lu.all;

import org.junit.Test;

import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-09-19
 */
public class 摩尔投票_众数_q169_多数元素 {

    @Test
    public void test(){
        System.out.println(majorityElement(new int[]{6, 5, 5}));
    }

    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                if (count != 0) {
                    count--;
                } else {
                    count = 1;
                    res = nums[i];
                }
            }
        }
        return res;
    }

//    public int majorityElement(int[] nums) {
//        Hill hill = new Hill();
//        for (int num : nums) {
//            hill.attack(num);
//        }
//        return hill.getCurrent();
//    }
//
//    public class Hill {
//        private Integer current;
//        private int number;
//
//        public int getCurrent() {
//            return current;
//        }
//
//        public void attack(int n) {
//            if (current == null) {
//                current = n;
//                number++;
//                return;
//            }
//            if (Objects.equals(n, current)) {
//                number++;
//                return ;
//            }
//            number--;
//            if (number == 0) {
//                current = null;
//            }
//        }
//    }

}
