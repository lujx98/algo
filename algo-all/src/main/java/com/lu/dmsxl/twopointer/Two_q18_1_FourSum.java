package com.lu.dmsxl.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-03-27
 */
public class Two_q18_1_FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //todolu:技巧
                    long sum = (long)nums[i] + nums[j] + nums[right] + nums[left];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        returnList.add(Arrays.asList(nums[i], nums[j], nums[right], nums[left]));
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }

            }
        }
        return returnList;
    }

//    public static void main(String[] args) {
//        System.out.println(threeSumClosest(new int[]{-1,0,1,1,55}, 3));
//    }
//
//    public static int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int diff = Integer.MAX_VALUE;
//        Integer res = null;
//        for (int i = 0; i < nums.length-2; i++) {
//            int left = i+1;
//            int right = nums.length-1;
//            while (right>left&&nums[right]+nums[left]+nums[i]!=target){
//                int abs = Math.abs(nums[right] + nums[left] + nums[i] - target);
//                if (abs <diff){
//                    diff = abs;
//                    res = nums[right] + nums[left] + nums[i];
//                }
//                if (nums[right]+nums[left]+nums[i]==target){
//                    return target;
//                }
//                if (nums[right]+nums[left]+nums[i]>target){
//                    right--;
//                }else {
//                    left++;
//                }
//            }
//            if (nums[right]+nums[left]+nums[i]==target&&right!=left&&left!=i){
//                return target;
//            }
//        }
//        return res;
//    }

}
