package com.lu.algo.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-03-19
 */
public class q118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i ) {
                    list.add(1);
                    continue;
                }
                list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            res.add(list);
        }
        return res;
    }

}
