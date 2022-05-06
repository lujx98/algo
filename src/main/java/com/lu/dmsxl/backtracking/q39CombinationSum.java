package com.lu.dmsxl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-06
 */
public class q39CombinationSum {

    @Test
    public void test() {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    private List<List<Integer>> returnList = new ArrayList<List<Integer>>();
    private LinkedList<Integer> path = new LinkedList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(target, candidates, 0);
        return returnList;
    }

    public void backTracking(int target, int[] candidates, int index) {
        if (sum == target) {
            returnList.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        //todo:枝剪
        for (; index < candidates.length; index++) {

            int candidate = candidates[index];
            path.add(candidate);
            sum += candidate;
            backTracking(target, candidates, index);
            sum -= candidate;
            path.removeLast();
        }
    }

}
