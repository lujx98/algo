package com.lu.all;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author sheldon
 * @date 2023-07-26
 */
public class 贪心_堆_交错排列_q767_重构字符串 {

    @Test
    public void test() {
        System.out.println(reorganizeString("vvvlo"));
    }

    public String reorganizeString(String s) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (stringBuilder.length() != 0 && poll[0] == stringBuilder.charAt(stringBuilder.length() - 1)) {
                int[] poll1 = queue.poll();
                if (poll1 == null || poll1[0] == poll[0]) {
                    return "";
                }
                stringBuilder.append((char) poll1[0]);
                poll1[1]--;
                if (poll1[1] != 0) {
                    queue.offer(poll1);
                }
                queue.offer(poll);
            } else {
                poll[1]--;
                stringBuilder.append((char) poll[0]);
                if (poll[1] != 0) {
                    queue.offer(poll);
                }
            }
        }
        return stringBuilder.toString();
    }

}
