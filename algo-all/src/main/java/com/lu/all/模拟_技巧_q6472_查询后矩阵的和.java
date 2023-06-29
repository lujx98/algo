package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-06-04
 */
public class 模拟_技巧_q6472_查询后矩阵的和 {

    @Test
    public void test() {
        System.out.println(matrixSumQueries(10, ArrayUtils.makeIntArraysByString("[[0,7,84123],[1,0,5707],[1,4,45290],[1,6,75687],[0,8,70650],[1,5,22049],[0,3,23649],[0,0,95608],[1,7,1511],[1,3,82622],[1,8,8841],[0,9,73741],[1,1,28493],[0,1,99037],[1,2,40340],[0,4,75358],[0,5,18711],[0,6,66502],[0,2,87159],[1,9,39613],[1,1,79509],[0,3,21027],[0,7,97550],[1,6,9720],[1,9,92871]]")));
    }

    public long matrixSumQueries(int n, int[][] queries) {
        boolean[] rowSet = new boolean[n];
        boolean[] columnSet = new boolean[n];
        int rowRemain = n;
        int columnRemain = n;
        long count = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] query = queries[i];
            if (query[0] == 1 && !rowSet[query[1]]) {
                count += columnRemain * (long)query[2];
                rowRemain--;
                rowSet[query[1]] = true;
            }
            if (query[0] == 0 && !columnSet[query[1]]) {
                count += rowRemain * (long)query[2];
                columnRemain--;
                columnSet[query[1]] = true;
            }
        }
        return count;
    }

}
