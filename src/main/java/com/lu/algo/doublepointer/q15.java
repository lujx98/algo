package com.lu.algo.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-03-26
 */
public class q15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1,-1,-1,0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int targetValue = -nums[i];
            int right = nums.length - 1;
            int left = i + 1;
            while (right > left) {
                if (nums[right]+nums[left]>targetValue){
                    //todolu：自增自减放前面放后面  区别很大
                    while (left<right&&nums[right]==nums[--right]) {
                    }
                }else if (nums[right]+nums[left]<targetValue) {
                    while (left<right&&nums[left]==nums[++left]) {
                    }
                }else {
                    ArrayList<Integer> objects = new ArrayList<>();
                    objects.add(nums[right]);
                    objects.add(nums[left]);
                    objects.add(nums[i]);
                    returnList.add(objects);
                    while (left<right&&nums[right]==nums[--right]);
                    while (left<right&&nums[left]==nums[++left]);
                }
            }
        }
        return returnList;
    }
}
