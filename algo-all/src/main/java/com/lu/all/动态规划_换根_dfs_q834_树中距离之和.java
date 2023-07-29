package com.lu.all;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-07-29
 */
public class 动态规划_换根_dfs_q834_树中距离之和 {

    private int[] size;
    private int[] res;
    private ArrayList<Integer>[] pic;


    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.pic = new ArrayList[n];
        Arrays.setAll(pic, a -> new ArrayList<>());
        for (int[] edge : edges) {
            pic[edge[0]].add(edge[1]);
            pic[edge[1]].add(edge[0]);
        }
        this.size = new int[n];
        this.res = new int[n];
        dfs(0, -1, 0);
        dfs2(0, -1);
        return res;
    }

    private void dfs(int i, int father, int depth) {
        res[0] += depth;
        ArrayList<Integer> integers = pic[i];
        size[i] = 1;
        for (Integer integer : integers) {
            if (integer != father) {
                dfs(integer, i, depth + 1);
                size[i] += size[integer];
            }
        }
    }

    private void dfs2(int cur, int father) {
        for (Integer integer : pic[cur]) {
            if (integer != father) {
                res[integer] = res[cur] - size[integer] + (pic.length - size[integer]);
                dfs2(integer, cur);
            }
        }
    }

}
