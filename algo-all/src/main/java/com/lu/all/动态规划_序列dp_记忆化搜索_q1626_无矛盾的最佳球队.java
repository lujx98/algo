package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sheldon
 * @date 2023-03-22
 */
public class 动态规划_序列dp_记忆化搜索_q1626_无矛盾的最佳球队 {

    @Test
    public void test() {
        System.out.println(bestTeamScore(new int[]{1, 3, 7, 3, 2, 4, 10, 7, 5}, new int[]{4, 5, 2, 1, 1, 2, 4, 1, 4}));
    }

    private Integer[][] memo;

    public int bestTeamScore(int[] scores, int[] ages) {
        Integer[] temp = new Integer[ages.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i;
        }
        Arrays.sort(temp, (v1, v2) -> {
            if (ages[v1] - ages[v2] != 0) {
                return ages[v1] - ages[v2];
            }
            return scores[v1] - scores[v2];
        });
        Arrays.sort(ages);
        int[] scores1 = new int[ages.length];
        for (int i = 0; i < scores.length; i++) {
            scores1[i] = scores[temp[i]];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = ages.length - 1; i >= 0; i--) {
            map.put(ages[i], i);
        }
        HashMap<Integer, Integer> endMap = new HashMap<>();
        for (int i = 0; i < ages.length; i++) {
            endMap.put(ages[i], i);
        }
        this.memo = new Integer[ages.length][ages.length];
        return dfs(0, -1, scores1, ages, map, endMap);
    }

    private int dfs(Integer index, int prev, int[] scores, int[] ages, TreeMap<Integer, Integer> map,
                    HashMap<Integer, Integer> endMap) {
        if (index == null) {
            return 0;
        }
        if (prev != -1 && memo[index][prev] != null) {
            return memo[index][prev];
        }
        Map.Entry<Integer, Integer> entry = map.higherEntry(ages[index]);
        Integer next = null;
        if (entry != null) {
            next = entry.getValue();
        }
        int res = dfs(next, prev, scores, ages, map, endMap);
        int sum = 0;
        for (int i = index; i <= endMap.get(ages[index]); i++) {
            if (prev == -1 || scores[i] >= scores[prev]) {
                sum += scores[i];
                res = Math.max(res, dfs(next, i, scores, ages, map, endMap) + sum);
            }
        }
        if (prev != -1) {
            return memo[index][prev] = res;
        }
        return res;
    }

}
