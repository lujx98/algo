package com.lu.daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-02-08
 */
public class q1233_排序_模拟_字典树_删除子文件夹 {

    @Test
    public void test() {
        System.out.println(removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int right = 1, left = 0; right < folder.length; right++) {
            if (!aaa(folder[right], folder[left])) {
                left = right;
                res.add(folder[right]);
            }
        }
        return res;
    }

    private boolean aaa(String s, String s1) {
        String[] cand = s.split("/");
        String[] prev = s1.split("/");
        for (int i = 0; i < prev.length && i < cand.length; i++) {
            if (!cand[i].equals(prev[i])){
                return false;
            }
        }
        return true;
    }

}
