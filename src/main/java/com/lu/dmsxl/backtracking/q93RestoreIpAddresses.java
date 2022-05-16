package com.lu.dmsxl.backtracking;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-16
 */
public class q93RestoreIpAddresses {
    @Test
    public void test() {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    private LinkedList<String> res = new LinkedList<>();
    private List<String> returnList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0);
        return returnList;
    }

    private void backTracking(String s, int start) {
        if (res.size() == 4) {
            String[] strings = res.toArray(new String[res.size()]);
            String join = String.join(".", strings);

            if (join.length() == s.length() - 3) {
                returnList.add(join);
            }
            return;
        }
        for (int i = start + 1; i < s.length() - 1 && start - i <= 3; i++) {
            res.add(s.substring(start, i));
            backTracking(s, start + 1);
            res.removeLast();
        }
    }

}
