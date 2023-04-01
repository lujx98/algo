package com.lu.dmsxl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-06
 */
public class q131Partition {

    @Test
    public void test() {
        System.out.println(new StringBuilder("aaa").toString().equals(new StringBuilder("aaa").toString()));
    }

    private LinkedList<String> path = new LinkedList<>();
    private List<List<String>> returnList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return returnList;
    }

    public void backTracking(String s, int index) {
        if (index >= s.length()) {
            returnList.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                String substring = s.substring(index, i + 1);
                path.add(substring);
            } else {
                continue;
            }
            backTracking(s, i + 1);
            path.removeLast();
        }

    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
