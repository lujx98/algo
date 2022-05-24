package com.lu.dmsxl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-24
 */
public class q46Permute {

    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    private final LinkedList<Integer> path = new LinkedList<Integer>();
    private final List<List<Integer>> resturnList = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        backTracking(nums, 0);
        return resturnList;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (nums.length == path.size()) {
            resturnList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
            } else {
                continue;
            }
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

}