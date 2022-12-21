package com.lu.daily;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-12-19
 */
public class q1971_1_图论_并查集_DFS {

    @Test
    public void test(){
        validPath(6,new int[][]{new int[]{0,1},new int[]{0,2},new int[]{3,5},new int[]{5,4},new int[]{4,3}},0,5);
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //todo：
        //init var
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            List<Integer> list = lists[x];
            list.add(y);
            List<Integer> list1 = lists[y];
            list1.add(x);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, visited, lists);
    }

    private boolean dfs(int source, int destination, boolean[] visited, List<Integer>[] lists) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (int next : lists[source]) {
            if (!visited[next] && dfs(next, destination, visited, lists)) {
                return true;
            }
        }
        return false;
    }

}
