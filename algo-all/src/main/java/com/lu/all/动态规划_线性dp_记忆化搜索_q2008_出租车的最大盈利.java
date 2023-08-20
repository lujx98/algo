package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-08-20
 */
public class 动态规划_线性dp_记忆化搜索_q2008_出租车的最大盈利 {

    @Test
    public void test() {
        System.out.println(maxTaxiEarnings(20, ArrayUtils.makeIntArraysByString("[[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]")));
    }

    private int[][] rides;
    private long[] memo;
    private TreeMap<Integer, Integer> map;
    private int n;


    public long maxTaxiEarnings(int n, int[][] rides) {
        this.n = n;
        this.rides = rides;
        Arrays.sort(rides, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        this.map = map;
        for (int i = rides.length - 1; i >= 0; i--) {
            int[] integers = rides[i];
            map.put(integers[0], i);
        }
        this.memo = new long[rides.length];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private long dfs(int cur) {
        if (cur >= rides.length) {
            return 0;
        }
        if (memo[cur] != -1) {
            return memo[cur];
        }
        long res = dfs(cur + 1);
        int[] integers = rides[cur];
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(integers[1]);
        if (entry != null) {
            res = Math.max(res, dfs(entry.getValue()) + integers[2] + (integers[1] - integers[0]));
        } else {
            res = Math.max(res, integers[2] + (integers[1] - integers[0]));
        }
        return memo[cur] = res;
    }


}
