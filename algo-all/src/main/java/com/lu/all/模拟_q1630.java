package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-03-23
 */
public class 模拟_q1630 {

    @Test
    public void test() {
        System.out.println(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] copy = new int[r[i] - l[i] + 1];
            System.arraycopy(nums, l[i], copy, 0, r[i] - l[i] + 1);
            Arrays.sort(copy);
            int dif = copy[1] - copy[0];
            boolean isArray = true;
            for (int j = 2; j < copy.length; j++) {
                if (copy[j] - copy[j - 1] != dif) {
                    isArray = false;
                }
            }
            res.add(isArray);
        }
        return res;
    }

}
