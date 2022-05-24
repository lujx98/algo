package com.lu.dmsxl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-20
 */
public class q491FindSubsequences {

    @Test
    public void test() {
        System.out.println(findSubsequences(new int[]{4, 6, 7, 7}));
    }

    private List<List<Integer>> returnList = new ArrayList();
    private LinkedList<Integer> path = new LinkedList();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return returnList;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            returnList.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (((!path.isEmpty() && nums[i] < path.peekLast()) || used[nums[i] + 100] == 1)) {
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 100] = 1;
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

}
