package com.lu.daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-02-28
 */
public class q2363 {

    @Test
    public void test() {
        System.out.println(mergeSimilarItems(new int[][]{new int[]{5, 1}, new int[]{4, 2}, new int[]{3, 3}, new int[]{2, 4}, new int[]{1, 5}}, new int[][]{new int[]{7, 1}, new int[]{6, 2}, new int[]{5, 3}, new int[]{4, 4}}).toString());
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1, Comparator.comparingInt(v -> v[0]));
        Arrays.sort(items2, Comparator.comparingInt(v -> v[0]));
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;     // 遍历item1的指针
        int right = 0;     // 遍历item2的指针
        int n1 = items1.length;     // item1长度
        int n2 = items2.length;     // item2长度
        while (left < n1 && right < n2) {
            if (items1[left][0] < items2[right][0]) {
                List<Integer> ans = new ArrayList<>();
                ans.add(items1[left][0]);
                ans.add(items1[left][1]);
                res.add(ans);
                left++;
            } else if (items1[left][0] > items2[right][0]) {
                List<Integer> ans = new ArrayList<>();
                ans.add(items2[right][0]);
                ans.add(items2[right][1]);
                res.add(ans);
                right++;
            } else {
// 两个item的价值一样
                List<Integer> ans = new ArrayList<>();
                ans.add(items1[left][0]);
                ans.add(items1[left][1] + items2[right][1]);
                res.add(ans);
                left++;
                right++;
            }
        }

        while (left < n1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(items1[left][0]);
            ans.add(items1[left][1]);
            res.add(ans);
            left++;
        }
        // 如果p2未遍历完，将item2剩下的item加入结果集
        while (right < n2) {
            List<Integer> ans = new ArrayList<>();
            ans.add(items2[right][0]);
            ans.add(items2[right][1]);
            res.add(ans);
            right++;
        }
        return res;
    }

}
