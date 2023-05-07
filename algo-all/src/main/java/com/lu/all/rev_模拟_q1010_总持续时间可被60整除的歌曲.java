package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-05-07
 */
public class rev_模拟_q1010_总持续时间可被60整除的歌曲 {

    @Test
    public void test() {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    }

    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        for (int t : time) {
            cnt[t % 60]++;
        }
        long res = 0;
        for (int i = 1; i < 30; i++) {
            res += cnt[i] * cnt[60 - i];
        }
        res += (long) cnt[0] * (cnt[0] - 1) / 2 + (long) cnt[30] * (cnt[30] - 1) / 2;
        return (int) res;
    }

}
