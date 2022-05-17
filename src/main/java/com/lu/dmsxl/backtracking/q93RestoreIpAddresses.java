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

    private int pointCount = 0;
    private List<String> returnList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0);
        return returnList;
    }

    private void backTracking(String s, int start) {
        if (pointCount == 3) {
            if (isValid(s, start, s.length() - 1)) {
                returnList.add(s);
            }
            return;
        }
        for (int i = start; i < s.length() - 1 && start - i <= 3; i++) {
            if (isValid(s, start, i)) {
                //在str的后⾯插⼊⼀个逗点
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointCount++;
                // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                backTracking(s, i + 2);
                // 回溯
                pointCount--;
                // 回溯删掉逗点
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            // 如果⼤于255了不合法
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

}
