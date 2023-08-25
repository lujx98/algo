package com.lu.all;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sheldon
 * @date 2023-08-25
 */
public class 动态规划_线性dp_选还是不选_记忆化搜索_q1235_规划兼职工作 {

    @Test
    public void test() {
        System.out.println(jobScheduling(new int[]{4, 2, 4, 8, 2}, new int[]{5, 5, 5, 10, 8}, new int[]{1, 2, 8, 10, 4}));
    }

    private int[] startTime;
    private int[] endTime;
    private int[] profit;
    private TreeMap<Integer, Integer> map;
    private int[] memo;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Integer[] mapping = new Integer[startTime.length];
        for (int i = 0; i < mapping.length; i++) {
            mapping[i] = i;
        }
        Arrays.sort(mapping, (v1, v2) -> {
            if (startTime[v1] != startTime[v2]) {
                return startTime[v1] - startTime[v2];
            }
            return endTime[v1] - endTime[v2];
        });

        int[] temps = new int[startTime.length];
        for (int i = 0; i < temps.length; i++) {
            temps[i] = startTime[mapping[i]];
        }
        this.startTime = temps;
        int[] tempe = new int[startTime.length];
        for (int i = 0; i < temps.length; i++) {
            tempe[i] = endTime[mapping[i]];
        }
        this.endTime = tempe;
        int[] tempp = new int[startTime.length];
        for (int i = 0; i < temps.length; i++) {
            tempp[i] = profit[mapping[i]];
        }
        this.profit = tempp;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = startTime.length - 1; i >= 0; i--) {
            map.put(this.startTime[i], i);
        }
        this.map = map;
        this.memo = new int[startTime.length];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= startTime.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = dfs(i + 1);
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(endTime[i]);
        res = Math.max(res, (entry == null ? 0 : dfs(entry.getValue())) + profit[i]);
        return memo[i] = res;
    }

}
