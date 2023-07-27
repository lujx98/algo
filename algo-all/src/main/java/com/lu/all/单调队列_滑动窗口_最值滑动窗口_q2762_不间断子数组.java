package com.lu.all;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sheldon
 * @date 2023-07-02
 */
public class 单调队列_滑动窗口_最值滑动窗口_q2762_不间断子数组 {

    private PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
        }
    });
    private PriorityQueue<Integer> max = new PriorityQueue<>();

    public long continuousSubarrays(int[] nums) {
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
