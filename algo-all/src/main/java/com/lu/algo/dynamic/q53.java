package com.lu.algo.dynamic;

/**
 * @author sheldon
 * @date 2022-03-19
 */
public class q53 {
    //max{f(i−1)+nums[i],nums[i]}
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
//        int index  = 0;
//        int[][] array = new int[nums.length - index][nums.length - index];
//        for (int i = 0; i < array[0].length; i++) {
//            array[0][i]=nums[index];
//        }
//        for (int i = 1; i < nums.length - index; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                array[i][j]=Math.max(nums[index+i],nums[index+i]+array[i-1][j]);
//            }
//        }
//        int ans=array[0][0];
//        for (int[] ints : array) {
//            if (ints[0]>ans){
//                ans = ints[0];
//            }
//        }
//        return ans;
        //todo:官方答案代码少一半 时间也少一半 可以优化
        /**
         *         int pre = 0, maxAns = nums[0];
         *         for (int x : nums) {
         *             pre = Math.max(pre + x, x);
         *             maxAns = Math.max(maxAns, pre);
         *         }
         *         return maxAns;
         */

        int length = nums.length;
        if (length ==1){
            return nums[0];
        }
        int[] ints = new int[length];
        int max = nums[0];
        ints[0] = nums[0];
        for (int i = 1; i < length; i++) {
            int maxInternal = Math.max(nums[i], nums[i] + ints[i - 1]);
            ints[i]=maxInternal;
            if (maxInternal>max){
                max=maxInternal;
            }
        }
        return max;
    }
}
