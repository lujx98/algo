package com.lu.all;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author sheldon
 * @date 2023-07-02
 */
public class 单调队列_滑动窗口_最值滑动窗口_q2762_不间断子数组 {

    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > 2) {
                map.merge(nums[left], -1, Integer::sum);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res += (i - left + 1);
        }
        return res;
    }

    private PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
        }
    });
    private PriorityQueue<Integer> max = new PriorityQueue<>();

    public long continuousSubarrays1(int[] nums) {
        int res = 0;
        for (int right = 0, left = 0; right < nums.length; right++) {
            min.offer(nums[right]);
            max.offer(nums[right]);
            while (Math.abs(max.peek() - min.peek()) > 2) {
                min.remove(nums[left]);
                max.remove(nums[left]);
                left++;
            }
            res += (right - left + 1);
        }
        return res;
    }

}
