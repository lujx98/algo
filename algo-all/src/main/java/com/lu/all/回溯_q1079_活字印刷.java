package com.lu.all;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sheldon
 * @date 2023-05-20
 */
public class 回溯_q1079_活字印刷 {

    @Test
    public void test() {
        System.out.println(numTilePossibilities("AAB"));
    }

    private Set<String> set;
    private StringBuilder sb = new StringBuilder();
    private int res = 0;
    private boolean[] used;
    private String tiles;

    public int numTilePossibilities(String tiles) {
        this.set = new HashSet<>();
        this.used = new boolean[tiles.length()];
        this.tiles = tiles;
        for (int i = 0; i < tiles.toCharArray().length; i++) {
            dfs(i);
        }
        return res;
    }

    public void dfs(int cur) {
        used[cur] = true;
        String s = sb.append(tiles.charAt(cur)).toString();
        boolean contains = set.contains(s);
        if (contains) {
            sb.deleteCharAt(sb.length() - 1);
            used[cur] = false;
            return;
        }
        set.add(s);
        res++;
        for (int i = 0; i < tiles.toCharArray().length; i++) {
            if (used[i]) {
                continue;
            }
            dfs(i);
        }
        sb.deleteCharAt(sb.length() - 1);
        used[cur] = false;
    }

}
