package com.lu.algo.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-03-27
 */
public class q18 {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            if (i>0&&nums[i-1]==nums[i]){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if (j>i+1&&nums[j-1]==nums[j]){
                    continue;
                }
                int internalTarget = target - nums[i];
                int internalTarget1 =  (internalTarget - nums[j]) ;
                int right = nums.length-1;
                int left = j+1;
                while (right > left ){
                    if (internalTarget1>(nums[right]+nums[left])) {
                        do {
                            ++left;
                        }
                        while (right > left &&nums[left-1]==nums[left]);
                    }
                    else if (internalTarget1<(nums[right]+nums[left])) {
                        do {
                            --right;
                        }
                        while(right > left &&nums[right+1]==nums[right]);
                    }
                    else{
                        ArrayList<Integer> objects = new ArrayList<>();
                        objects.add(nums[right]);
                        objects.add(nums[left]);
                        objects.add(nums[i]);
                        objects.add(nums[j]);
                        returnList.add(objects);
                        do {
                            --right;
                        }
                        while(right > left &&nums[right+1]==nums[right]);
                        do {
                            ++left;
                        }
                        while (right > left &&nums[left-1]==nums[left]);
                    }
                }
            }
        }
        return returnList;
    }

}
