package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sheldon
 * @date 2023-08-20
 */
public class 动态规划_线性dp_记忆化搜索_q2830_销售利润最大化 {

    @Test
    public void test() {
        ArrayList<List<Integer>> objects = new ArrayList<>();
        for (int[] ints : ArrayUtils.makeIntArraysByString("[[0,0,1],[0,2,2],[1,3,2]]")) {
            objects.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
        }
        maximizeTheProfit(5, objects);
    }

    private int[] memo;
    private List<List<Integer>> offers;
    private TreeMap<Integer, Integer> map;
    private int n;

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        this.n = n;
        this.offers = offers;
        offers.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (!Objects.equals(o1.get(0), o2.get(0))) {
                    return o1.get(0) - o2.get(0);
                }
                return o1.get(1) - o2.get(1);
            }
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        this.map = map;
        for (int i = offers.size() - 1; i >= 0; i--) {
            List<Integer> integers = offers.get(i);
            map.put(integers.get(0), i);
        }
        this.memo = new int[offers.size()];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private int dfs(int cur) {
        if (cur >= offers.size()) {
            return 0;
        }
        if (memo[cur] != -1) {
            return memo[cur];
        }
        int res = dfs(cur + 1);
        List<Integer> integers = offers.get(cur);
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(integers.get(1) + 1);
        if (entry != null) {
            res = Math.max(res, dfs(entry.getValue()) + integers.get(2));
        } else {
            res = Math.max(res, integers.get(2));
        }
        return memo[cur] = res;
    }

}
