package com.lu.daily;

import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-02-02
 */
public class q1129_图论 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(shortestAlternatingPaths(3, new int[][]{new int[]{0,1}, new int[]{0,2}}, new int[][]{new int[]{1,0}})));
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        @SuppressWarnings("all")
        List<Integer>[][] lists = new List[2][n];
        Arrays.setAll(lists[1], a -> new ArrayList<>());
        Arrays.setAll(lists[0], a -> new ArrayList<>());
        for (int[] redEdge : redEdges) {
            lists[0][redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            lists[1][blueEdge[0]].add(blueEdge[1]);
        }
        //list[x,y] x表示颜色  y表示起点  数组元素表示终点
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        boolean[][] vis = new boolean[n][2];
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int start = poll[0], color = poll[1];
                if (res[start] == -1) {
                    res[start] = depth;
                }
//                vis[start][color] = true;
                color = (color + 1) % 2;
                for (Integer newStart : lists[color][start]) {
//                    if (!vis[newStart][color]) {
                        queue.offer(new int[]{newStart, color});
//                    }
                }
            }
            depth++;
        }
        return res;
    }

}
