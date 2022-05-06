package com.lu.dmsxl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-06
 */
public class q40CombinationSum2 {

    @Test
    public void test() {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> returnList = new ArrayList<>();
    private int sum = 0;
    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        backTracking(candidates, target, 0);
        return returnList;
    }

    private void backTracking(int[] candidates, int target, int index) {
        if (sum == target) {
            returnList.add(new ArrayList<Integer>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (; index < candidates.length && candidates[index] + sum <= target; index++) {
            //出现重复节点
            if (index > 0
                    && candidates[index] == candidates[index - 1]
                    && !used[index - 1]
            ) {
                continue;
            }
            int candidate = candidates[index];
            sum += candidate;
            path.add(candidate);
            used[index] = true;
            backTracking(candidates, target, index + 1);
            used[index] = false;
            path.removeLast();
            sum -= candidate;
        }
    }

}
