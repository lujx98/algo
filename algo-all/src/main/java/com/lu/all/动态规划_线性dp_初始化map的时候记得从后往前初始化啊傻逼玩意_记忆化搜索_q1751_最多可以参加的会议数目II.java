package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sheldon
 * @date 2023-08-27
 */
public class 动态规划_线性dp_初始化map的时候记得从后往前初始化啊傻逼玩意_记忆化搜索_q1751_最多可以参加的会议数目II {

    @Test
    public void test() {
        System.out.println(maxValue(ArrayUtils.makeIntArraysByString(
                "[[58,74,21],[61,87,66],[23,37,45],[36,87,81],[10,57,88],[67,77,84],[68,94,90],[25,38,86],[89,91,69],[34,50,69],[60,97,68],[8,43,42],[60,80,48],[45,71,19],[29,30,79],[48,77,10],[34,54,58],[37,84,54],[22,65,76],[52,92,29],[37,50,41],[18,96,33],[28,57,26],[13,62,83],[64,76,21],[9,33,78],[3,20,41]]"), 21));
    }

    private Integer[][] memo;
    private TreeMap<Integer, Integer> map;
    private int[][] events;


    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });
        this.map = new TreeMap<>();
        this.events = events;
        for (int i = events.length - 1; i >= 0; i--) {
            map.put(events[i][0], i);
        }
        this.memo = new Integer[events.length][k + 1];
        return dfs(0, k);
    }

    private int dfs(int index, int k) {
        if (k == 0 || index >= events.length) {
            return 0;
        }
        if (memo[index][k] != null) {
            return memo[index][k];
        }
        int res = dfs(index + 1, k);
        Map.Entry<Integer, Integer> entry = map.higherEntry(events[index][1]);
        res = Math.max(((entry == null ? 0 : dfs(entry.getValue(), k - 1)) + events[index][2]), res);
        return memo[index][k] = res;
    }

}
