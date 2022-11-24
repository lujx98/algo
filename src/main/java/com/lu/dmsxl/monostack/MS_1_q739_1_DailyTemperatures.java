package com.lu.dmsxl.monostack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author sheldon
 * @date 2022-11-24
 */
public class MS_1_q739_1_DailyTemperatures {

    @Test
    public void test() {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            Integer peek = stack.peek();
            if (temperatures[peek] < temperatures[i]) {
//                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
//                    res[stack.peek()]=i-stack.peek();
//                    stack.pop();
//                }
//              遇到第一个就应该停下来了
                int size = stack.size();
                for (int j = 0; j < size; j++) {
                    Integer pop = stack.peek();
                    if (temperatures[pop] < temperatures[i]) {
                        res[pop] = i - stack.pop();
                    }else {
                        break;
                    }
                }
                stack.push(i);
            } else {
                stack.push(i);
            }
        }
        return res;
    }

}
