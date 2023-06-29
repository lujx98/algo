package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-06-29
 */
public class 贪心_q1253_重构2行二进制矩阵 {

    @Test
    public void test() {
        System.out.println(reconstructMatrix(2, 1, new int[]{1, 1, 1}));
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int i : colsum) {
            if (i == 2) {
                res.get(0).add(1);
                res.get(1).add(1);
                upper--;
                lower--;
            } else if (i == 0) {
                res.get(0).add(0);
                res.get(1).add(0);
            } else {
                if (upper >= lower) {
                    res.get(0).add(1);
                    res.get(1).add(0);
                    upper--;
                } else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                    lower--;
                }
            }
        }
        return upper == 0 && lower == 0 ? res : new ArrayList<>();
    }

}
