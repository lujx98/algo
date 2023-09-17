package com.lu.all;

import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-09-17
 */
public class 思维_频率_贪心_q2856_删除数对后的最小数组长度 {

    @Test
    public void test() {
        System.out.println(minLengthAfterRemovals(Arrays.asList(1, 3, 3, 3, 4)));
    }

    public int minLengthAfterRemovals(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        q.addAll(map.values());

        int res = nums.size();
        while (true) {
            Integer poll = q.poll();
            Integer poll1 = q.poll();
            if (poll1 != null && poll != null) {
                if (poll1 != 1) {
                    q.offer(--poll1);
                }
                if (poll != 1) {
                    q.offer(--poll);
                }
                res -= 2;
            } else {
                break;
            }
        }
        return res;
    }

}
