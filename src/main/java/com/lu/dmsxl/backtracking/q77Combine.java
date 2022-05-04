package com.lu.dmsxl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class q77Combine {

    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }

    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> returnList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return returnList;
    }

    private void backTracking(int n, int size, int index) {
        if (path.size() == size) {
            returnList.add(new ArrayList<>(path));
            return;
        }
        //已经选择了几个数：path.size()
        //还需要多少数字：size-path.size()
        for (int i = index; i <= n - (size - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, size, i + 1);
            path.removeLast();
        }
    }

}
