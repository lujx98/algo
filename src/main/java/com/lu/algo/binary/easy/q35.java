package com.lu.algo.binary.easy;

/**
 * @author sheldon
 * @date 2022-02-27
 */
public class q35 {

    public static void main(String[] args) {
        int[] ints =new int[]{1,3,4,5,6};
        System.out.println(searchInsert(ints, 4));
    }

    public static int searchInsert(int[] nums, int target) {
        int ans = nums.length ;
        int right = nums.length-1;
        int left = 0;
        while(left<=right){
            int mid = (right+left )/2;
            if (nums[mid]>=target){
                ans = mid;
                right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return ans;
    }

    public static int searchInsert1(int[] nums, int target) {
        return 0;
    }
}
