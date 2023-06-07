package com.lu.all;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-06-07
 */
public class 模拟_q2611_老鼠和奶酪 {

    @Test
    public void test() {
        System.out.println(miceAndCheese(new int[]{1, 4, 4, 6, 4}, new int[]{6, 5, 3, 6, 1}, 1));
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        RewardWrapper[] wrappers = new RewardWrapper[reward1.length];
        for (int i = 0; i < reward1.length; i++) {
            RewardWrapper rewardWrapper = new RewardWrapper();
            rewardWrapper.index = i;
            rewardWrapper.reword = reward1[i] - reward2[i];
            wrappers[i] = rewardWrapper;
        }
        Arrays.sort(wrappers, (v1, v2) -> v2.reword - v1.reword);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(wrappers[i].index);
        }
        int res = 0;
        for (int i = 0; i < reward1.length; i++) {
            if (set.contains(i)) {
                res += reward1[i];
            } else {
                res += reward2[i];
            }
        }
        return res;
    }

    private static class RewardWrapper {
        public int reword;
        public int index;
    }

}
