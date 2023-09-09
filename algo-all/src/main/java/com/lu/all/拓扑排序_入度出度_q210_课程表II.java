package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-09-09
 */
public class 拓扑排序_入度出度_q210_课程表II {

    @Test
    public void test() {
        System.out.println(Arrays.toString(findOrder(4, ArrayUtils.makeIntArraysByString("[[1,0],[2,0],[3,1],[3,2]]"))));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int[] cur = prerequisites[i];
            indegrees[cur[0]]++;
            if (map.containsKey(cur[1])) {
                map.get(cur[1]).add(cur[0]);
            } else {
                map.put(cur[1], new ArrayList<>(Collections.singletonList(cur[0])));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
                res.addLast(i);
                numCourses--;
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> integers = map.get(poll);
            if (integers != null) {
                for (Integer integer : integers) {
                    if (--indegrees[integer] == 0) {
                        queue.offer(integer);
                        res.addLast(integer);
                        numCourses--;
                    }
                }
            }
        }

        return numCourses != 0 ? new int[]{} : res.stream().mapToInt(Integer::intValue).toArray();
    }

}
