package com.lu.all;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-07-16
 */
public class rev_q6927_合法分割的最小下标 {

    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Counter> rightRefMap = new HashMap<>();
        PriorityQueue<Counter> rightCountSet = new PriorityQueue<>(new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        HashMap<Integer, Counter> leftRefMap = new HashMap<>();
        PriorityQueue<Counter> leftCountSet = new PriorityQueue<>(new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return o2.getCount() - o1.getCount();
            }
        });
        for (int i = nums.size() - 1; i >= 1; i--) {
            Counter tempcounter = rightRefMap.get(nums.get(i));
            if (tempcounter != null) {
                rightCountSet.remove(tempcounter);
                tempcounter.count++;
                rightCountSet.add(tempcounter);
            } else {
                Counter counter = new Counter();
                counter.val = nums.get(i);
                counter.count = 1;
                rightRefMap.put(counter.val, counter);
                rightCountSet.add(counter);
            }
        }

        Counter counter = new Counter();
        counter.val = nums.get(0);
        counter.count = 1;
        leftRefMap.put(counter.val, counter);
        leftCountSet.add(counter);


        for (int i = 1; i < nums.size(); i++) {
            Counter leftLast = leftCountSet.peek();
            Counter rightLast = rightCountSet.peek();
            if (leftLast.count * 2 > i &&
                    rightLast.count * 2 > (nums.size() - i)) {
                if (Objects.equals(leftLast.val, rightLast.val)) {
                    return i - 1;
                }
            }

            Counter counter1 = rightRefMap.get(nums.get(i));
            rightCountSet.remove(counter1);
            counter1.count--;
            rightCountSet.add(counter1);

            Counter counter2 = leftRefMap.get(nums.get(i));
            if (counter2 == null) {
                counter2 = new Counter();
                counter2.count = 1;
                counter2.val = nums.get(i);
                leftCountSet.add(counter2);
                leftRefMap.put(counter2.val, counter2);
            } else {
                leftCountSet.remove(counter2);
                counter2.count++;
                leftCountSet.add(counter2);
            }
        }


        return -1;
    }

    private static class Counter {
        public Integer val;

        public Integer getVal() {
            return val;
        }

        public Integer getCount() {
            return count;
        }

        public Integer count;
    }

}
