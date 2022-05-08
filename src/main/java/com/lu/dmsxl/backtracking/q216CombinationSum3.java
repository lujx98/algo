package com.lu.dmsxl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-04
 */
public class q216CombinationSum3 {


    @Test
    public void test() {
        System.out.println(combinationSum3(3, 7));
    }

    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> returnList = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);
        return returnList;
    }

//    private void backTracking(int k, int targetSum, int index) {
//        if (path.size() == k) {
//            if (sum == targetSum) {
//                returnList.add(new ArrayList<>(path));
//            }
//            return;
//        }
//        if (sum > targetSum) {
//            return;
//        }
//        //path.size()为已经添加的元素
//        //k-path.size()为剩余需要添加的元素
//        //9-(k-path.size())为分界点 在分界点的时候为index最大的情形 当k = 3 并且一个元素都未添加 当index大于7的时候都可以不用走接下面的流程了
//        //加1 表示闭区间
//        for (int i = index; i <= 9 - (k - path.size()) + 1; i++) {
//            sum += i;
//            path.add(i);
//            backTracking(k, targetSum, i + 1);
//            sum -= i;
//            path.removeLast();
//        }
//
//    }

    private void backTracking(int size, int n, int index) {
        if (path.size() == size) {
            if (sum == n) {
                returnList.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            path.add(i);
            sum+=i;
            backTracking(size, n, i + 1);
            sum-=i;
            path.removeLast();
        }

    }

}
