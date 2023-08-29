package com.lu.all;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sheldon
 * @date 2023-08-29
 */
public class 动态规划_记忆化搜索_q823_带因子的二叉树 {

    @Test
    public void test() {
        System.out.println(numFactoredBinaryTrees(new int[]{18, 3, 6, 2}));
    }

    private HashMap<Integer, Long> map = new HashMap<>();
    private Set<Integer> arrSet = new HashSet<>();
    private final static int MOD = (int) 1E9 + 7;
    private int[] arr;

    public int numFactoredBinaryTrees(int[] arr) {
        for (int i : arr) {
            arrSet.add(i);
        }
        this.arr = arr;
        long res = 0;
        for (int i : arr) {
            res = (res + dfs(i)) % MOD;
        }
        return (int) (res) % MOD;
    }

    public long dfs(int a) {
        if (map.containsKey(a)) {
            return map.get(a);
        }
        long res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < a && a % arr[i] == 0 && arrSet.contains(a / arr[i])) {
                res += ((dfs(arr[i]) * dfs(a / arr[i])) % MOD) % MOD;
            }
        }
        map.put(a, res);
        return res % MOD;
    }

}
