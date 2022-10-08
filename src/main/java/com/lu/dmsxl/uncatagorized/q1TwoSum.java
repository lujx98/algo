package com.lu.dmsxl.uncatagorized;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author sheldon
 * @date 2022-09-15
 */
public class q1TwoSum {

    @Test
    public void test(){
        System.out.println(twoSum(new int[]{3, 2, 4}, 6).toString());
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new RuntimeException();
    }

//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i);
//        }
//        Arrays.sort(nums);
//        int firstIndex = 0;
//        int secIndex = nums.length - 1;
//        int sum;
//        while ((sum = nums[firstIndex] + nums[secIndex]) != target) {
//            if (sum > target) {
//                secIndex--;
//            } else {
//                firstIndex++;
//            }
//        }
//        return new int[]{map.get(nums[firstIndex]),map.get(nums[secIndex])};
//    }

}
