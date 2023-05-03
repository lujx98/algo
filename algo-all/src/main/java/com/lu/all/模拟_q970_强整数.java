package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-05-03
 */
public class 模拟_q970_强整数 {

    @Test
    public void test() {
        System.out.println(powerfulIntegers(2
                , 1, 10));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; Math.pow(x, i) <= bound - 1; i++) {
            for (int j = 0; Math.pow(y, j) <= bound - 1; j++) {
                int cur = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (cur <= bound) {
                    set.add(cur);
                }
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(set);
    }

}
