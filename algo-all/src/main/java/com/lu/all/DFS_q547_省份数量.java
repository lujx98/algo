package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-10-21
 */
public class DFS_q547_省份数量 {

    @Test
    public void test() {
        System.out.println(findCircleNum1(ArrayUtils.makeIntArraysByString("[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]")));
    }



    private boolean[] visited;
    private List<Integer>[] lists;

    public int findCircleNum1(int[][] isConnected) {
        this.lists = new List[isConnected.length];
        Arrays.setAll(lists, a -> new ArrayList<>());
        this.visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    lists[i].add(j);
                    lists[j].add(i);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int i1 = 0; i1 < lists[i].size(); i1++) {
            dfs(lists[i].get(i1));
        }
    }

}
