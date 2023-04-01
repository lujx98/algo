package com.lu.dmsxl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-24
 */
public class q47PermuteUnique {

    @Test
    public void test(){
        permuteUnique(new int[]{1,1,2});
    }

    private List<List<Integer>> resultList = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        Arrays.sort(nums);
        backTracking(nums);
        return resultList;
    }

    private void backTracking(int[] nums) {
        if (nums.length == path.size()) {
            resultList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            //todolu:false也可以是什么原理
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == true) {
                continue;
            }
            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backTracking(nums);
                path.removeLast();
                used[i] = false;
            }
        }
    }

}
