package com.lu.all;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-05-03
 */
public class 搜索_q1376_通知所有员工所需的时间 {

    private int[] manager;
    private int[] informTime;
    private int res = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] arrayLists = new ArrayList[n];
        Arrays.setAll(arrayLists, e -> new ArrayList<>());
        for (int i = 0; i < manager.length; i++) {
            if (i != headID) {
                arrayLists[manager[i]].add(i);
            }
        }
        this.manager = manager;
        this.informTime = informTime;
        dfs(headID, 0, arrayLists);
        return res;
    }

    private void dfs(int curIndex, int curTime, ArrayList<Integer>[] arrayLists) {
        curTime += informTime[curIndex];
        res = Math.max(res, curTime);
        for (Integer integer : arrayLists[curIndex]) {
            dfs(integer, curTime, arrayLists);
        }
    }

}
