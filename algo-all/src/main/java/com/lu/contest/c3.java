package com.lu.contest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class c3 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findIndices(new int[]{0, 4, 7, 2}, 2, 7)));
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if (nums.length == 1) {
            if (indexDifference == 0 && valueDifference == 0) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        if (indexDifference >= nums.length) {
            return new int[]{-1, -1};
        }
        TreeMap<Integer, List<Integer>> temp = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.get(nums[i]) != null) {
                temp.get(nums[i]).add(i);
            } else {
                temp.put(nums[i], new ArrayList<>(Arrays.asList(i)));
            }
        }

        if (indexDifference != 0) {
            for (int i = 0; i <= indexDifference - 1; i++) {
                List<Integer> integers = temp.get(nums[i]);
                integers.remove((Integer) i);
                if (integers.isEmpty()) {
                    temp.remove(nums[i]);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            Integer integer = temp.ceilingKey(nums[i] + valueDifference);
            if (integer != null && Math.abs(integer - nums[i]) >= valueDifference) {
                return new int[]{temp.get(integer).get(0), i};
            }
            integer = temp.floorKey(nums[i] - valueDifference);
            if (integer != null && Math.abs(integer - nums[i]) >= valueDifference) {
                return new int[]{temp.get(integer).get(0), i};
            }
            if (i + indexDifference <= nums.length - 1) {
                List<Integer> integers = temp.get(nums[i + indexDifference]);
                integers.remove((Integer) (i + indexDifference));
                if (integers.isEmpty()) {
                    temp.remove(nums[i + indexDifference]);
                }
            }
            if (i - indexDifference >= 0) {
                List<Integer> integers = temp.get(nums[i - indexDifference]);
                if (integers == null) {
                    temp.put(nums[i - indexDifference], new ArrayList<>(Arrays.asList(i - indexDifference)));
                } else {
                    integers.add(i - indexDifference);
                }
            }
        }
        return new int[]{-1, -1};
    }

}
