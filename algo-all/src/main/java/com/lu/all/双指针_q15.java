package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-03-26
 */
public class 双指针_q15 {

    @Test
    public void test() {
        System.out.println(threeSum1(new int[]{0, 0, 0, 0}));
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1, target = -nums[i];
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> objects = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    objects.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (nums[left + 1] == nums[left] && left < right) left++;
                    while (nums[right - 1] == nums[right] && left < right) right--;
                    left++;
                    right--;
                }
            }
        }

        return objects;
    }

//
//    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{1,-1,-1,0}));
//    }
//
//    public static List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        ArrayList<List<Integer>> returnList = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] > 0) {
//                break;
//            }
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            int targetValue = -nums[i];
//            int right = nums.length - 1;
//            int left = i + 1;
//            while (right > left) {
//                if (nums[right]+nums[left]>targetValue){
//                    //todolu：自增自减放前面放后面  区别很大
//                    while (left<right&&nums[right]==nums[--right]) {
//                    }
//                }else if (nums[right]+nums[left]<targetValue) {
//                    while (left<right&&nums[left]==nums[++left]) {
//                    }
//                }else {
//                    ArrayList<Integer> objects = new ArrayList<>();
//                    objects.add(nums[right]);
//                    objects.add(nums[left]);
//                    objects.add(nums[i]);
//                    returnList.add(objects);
//                    while (left<right&&nums[right]==nums[--right]);
//                    while (left<right&&nums[left]==nums[++left]);
//                }
//            }
//        }
//        return returnList;
//    }
}
