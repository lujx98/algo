package com.lu.dmsxl;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-09-18
 */
public class q119GetRow {

    @Test
    public void test() {
        System.out.println(getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> objects = new ArrayList<>();
        objects.add(1);
        list.add(objects);
        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(1);
            List<Integer> integers = list.get(i - 1);
            for (int j = 1; j < i; j++) {
                list1.add(integers.get(j - 1) + integers.get(j));
            }
            list1.add(1);
            list.add(list1);
        }
        return list.get(rowIndex);
    }

    public List<Integer> getRowScrollingArray(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                }else {
                    cur.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre = cur;
        }
        return pre;
    }

    public List<Integer> getRowScrollingArray1(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                }else {
                    cur.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre = cur;
        }
        return pre;
    }

}
