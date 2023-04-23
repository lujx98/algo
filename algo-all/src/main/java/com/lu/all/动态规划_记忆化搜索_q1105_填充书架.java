package com.lu.all;

import com.lu.structure.ArraysUtils;
import org.junit.Test;

import java.util.Map;

/**
 * @author sheldon
 * @date 2023-04-23
 */
public class 动态规划_记忆化搜索_q1105_填充书架 {

    @Test
    public void test() {
        System.out.println(minHeightShelves(ArraysUtils.makeIntArraysByString("[1,3],[2,4],[3,2]"), 6));
    }

    private int[][] books;
    private int[] memo;
    private int shelfWidth;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        memo = new int[books.length];
        this.shelfWidth = shelfWidth;
        this.books = books;
        return dfs(0);
    }

    private int dfs(int book) {
        if (book >= books.length) {
            return 0;
        }
        if (memo[book] != 0) {
            return memo[book];
        }
        int count = 0;
        int res = Integer.MAX_VALUE;
        int height = books[book][1];
        for (int i = book; i < books.length; i++) {
            if (count + books[i][0] <= shelfWidth) {
                int dfs = dfs(i + 1);
                res = Math.min(res, (dfs + (height = Math.max(height, books[i][1]))));
                count += books[i][0];
            } else {
                break;
            }
        }
        return memo[book] = res;
    }

}
