package com.lu.all;

import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-08-16
 */
public class 模拟_q2682_找出转圈游戏输家 {

    public int[] circularGameLosers(int n, int k) {
        HashSet<Integer> set = new HashSet<>();
        int cur = 1;
        int multi = 1;
        while (!set.contains(cur)) {
            set.add(cur);
            cur += k * multi++;
            cur = (cur - 1) % n + 1;
        }
        int[] res = new int[n - set.size()];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                res[index++] = i;
            }
        }
        return res;
    }

}
