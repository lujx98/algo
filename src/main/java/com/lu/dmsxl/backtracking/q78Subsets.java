package com.lu.dmsxl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-16
 */
public class q78Subsets {

    private List<List<Integer>> resList = new ArrayList<List<Integer>>();
    private LinkedList<Integer> res = new LinkedList<Integer>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0){
            resList.add(new ArrayList<>());
            return resList;
        }
        backTrack(nums, 0);
        return resList;
    }

    private void backTrack(int[] nums, int start) {
        resList.add(new ArrayList<Integer>(res));
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            res.add(nums[i]);
            backTrack(nums, i + 1);
            res.removeLast();
        }
    }

}
