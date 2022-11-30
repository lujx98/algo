package com.lu.daily;

import java.util.*;

/**
 * @author sheldon
 * @date 2022-11-30
 */
public class q895_1 {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
    }

    static class FreqStack {

        public Map<Integer, Integer> freqMap = new HashMap<>();
        private List<Deque<Integer>> list = new ArrayList<>();

        public FreqStack() {
            list.add(new LinkedList<>());
        }

        public void push(int val) {
            Integer valFrep = freqMap.getOrDefault(val, 0);
            freqMap.put(val, valFrep + 1);
            if (valFrep > list.size() - 1) {
                Deque<Integer> integers = new LinkedList<>();
                integers.push(val);
                list.add(integers);
            } else {
                Deque<Integer> deque = list.get(valFrep);
                deque.push(val);
            }
        }

        public int pop() {
            int back = list.size() - 1;
            int val = list.get(back).pop(); // 弹出最右侧栈的栈顶
            if (list.get(back).isEmpty()) // 栈为空
                list.remove(back); // 删除
            freqMap.put(val, freqMap.get(val) - 1); // 更新频率
            return val;
        }

//        public int pop() {
//            int count = 1;
//            while (count != list.size() + 1) {
//                Deque<Integer> deque = list.get(list.size() - count);
//                if (deque.isEmpty()) {
        // todolu：

//                    count++;
//                    continue;
//                }
//                Integer pop = deque.pop();
//                Integer integer = freqMap.get(pop);
//                freqMap.put(pop, --integer);
//                return pop;
//            }
//            throw new RuntimeException();
//        }
    }


}
