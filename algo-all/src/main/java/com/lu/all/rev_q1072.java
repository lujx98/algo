package com.lu.all;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author sheldon
 * @date 2023-05-15
 */
public class rev_q1072 {

    @Test
    public void test() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

//        System.out.println(maxEqualRowsAfterFlips(ArrayUtils.makeIntArraysByString("[[0,1],[1,1]]")));
    }



//    public int maxEqualRowsAfterFlips(int[][] matrix) {
//        BigInteger[] ints = new BigInteger[matrix.length];
//        for (int i = 0; i < matrix.length; i++) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int matrix1 : matrix[i]) {
//                stringBuilder.append(matrix1);
//            }
//            ints[i] = new BigInteger(stringBuilder.toString(), 2);
//        }
//
//        int res = 1;
//        BigInteger the = BigInteger.ONE.shiftLeft(matrix[0].length).subtract(BigInteger.ONE);
//        for (int i = 0; i < ints.length; i++) {
//            int cur = 1;
//            for (int j = 0; j < ints.length; j++) {
//                if (j == i) {
//                    continue;
//                }
//                if (((ints[i].equals(ints[j]))) || ((ints[i].or(ints[j]).equals(the)) && ((ints[i].and(ints[j]).equals(BigInteger.ZERO))))) {
//                    cur++;
//                }
//            }
//            res = Math.max(res, cur);
//        }
//
//        return res;
//    }

}
