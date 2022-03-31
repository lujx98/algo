package com.lu.algo.doublepointer;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2022-03-27
 */
public class q16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,0,1,1,55}, 3));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        Integer res = null;
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (right>left&&nums[right]+nums[left]+nums[i]!=target){
                int abs = Math.abs(nums[right] + nums[left] + nums[i] - target);
                if (abs <diff){
                    diff = abs;
                    res = nums[right] + nums[left] + nums[i];
                }
                if (nums[right]+nums[left]+nums[i]==target){
                    return target;
                }
                if (nums[right]+nums[left]+nums[i]>target){
                    right--;
                }else {
                    left++;
                }
            }
            if (nums[right]+nums[left]+nums[i]==target&&right!=left&&left!=i){
                return target;
            }
        }
        return res;
    }

}
