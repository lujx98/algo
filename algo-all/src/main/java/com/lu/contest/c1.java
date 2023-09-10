package com.lu.contest;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class c1 {

    @Test
    public void test() {
        System.out.println();
    }

    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> res = new HashSet<>();
        for (List<Integer> num : nums) {
            for (Integer i = num.get(0); i <= num.get(1); i++) {
                res.add(i);
            }
        }
        return res.size();
    }

}
