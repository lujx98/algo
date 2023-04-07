package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-11-17
 */
public class rev_q792 {

    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] lists = new List[26];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            lists[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String word : words) {
            if (word.length() > s.length()) {
                res--;
                continue;
            }
            int cIndex = -1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                List<Integer> list = lists[c - 'a'];
                if (list.isEmpty() || list.get(list.size() - 1) <= cIndex) {
                    res--;
                    break;
                }
                cIndex = binarySearch(list, cIndex);
            }
        }
        return res;
    }

    /**
     * 二分查找  总是返回第一个比target更大的数
     *
     * @param list
     * @param target
     * @return
     */
    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }

    /**
     * 真·二分查找
     *
     * @param list
     * @param target
     * @return
     */
    private int search(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        System.out.println(binarySearch(objects,1));
        System.out.println(binarySearch(objects,1));


        System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

}
