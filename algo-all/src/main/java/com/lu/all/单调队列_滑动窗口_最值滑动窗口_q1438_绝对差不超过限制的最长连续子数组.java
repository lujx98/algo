package com.lu.all;

import org.checkerframework.checker.units.qual.min;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author sheldon
 * @date 2023-07-27
 */
public class 单调队列_滑动窗口_最值滑动窗口_q1438_绝对差不超过限制的最长连续子数组 {

    @Test
    public void test() {
        System.out.println(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
    }

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        int res = 1;
        for (int right = 0, left = 0; right < nums.length; right++) {
            queue.merge(nums[right], 1, Integer::sum);
            while (queue.lastKey() - queue.firstKey() > limit) {
                queue.merge(nums[left], -1, Integer::sum);
                if (queue.get(nums[left]) == 0) {
                    queue.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

//    public int longestSubarray(int[] nums, int limit) {
//        int left = 0, right = 0;
//        int res = 1;
//        PriorityQueue<Integer> minQ = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        for (; right < nums.length; right++) {
//            minQ.offer(nums[right]);
//            maxQ.offer(nums[right]);
//            while (maxQ.peek() - minQ.peek() > limit) {
//                minQ.remove(nums[left]);
//                maxQ.remove(nums[left++]);
//            }
//            res = Math.max(res, right - left + 1);
//        }
//        return res;
//    }

}
