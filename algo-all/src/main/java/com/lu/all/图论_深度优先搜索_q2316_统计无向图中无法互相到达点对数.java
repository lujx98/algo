package com.lu.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-10-21
 */
public class 图论_深度优先搜索_q2316_统计无向图中无法互相到达点对数 {

    private boolean[] visited;
    private List<Integer>[] edges1;

    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];
        this.edges1 = new List[n];
        Arrays.setAll(edges1, a -> new ArrayList<>());
        for (int[] edge : edges) {
            edges1[edge[1]].add(edge[0]);
            edges1[edge[0]].add(edge[1]);
        }

        long ans = 0;
        long incrument = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long cur = dfs(i);
                ans += cur * incrument;
                incrument += cur;
            }
        }
        return ans;
    }

    private long dfs(int i) {
        if (visited[i]) {
            return 0;
        }
        visited[i] = true;
        long res = 1;
        for (Integer integer : edges1[i]) {
            res += dfs(integer);
        }
        return res;
    }

}
