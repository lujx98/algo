package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-04-03
 */
public class rev_字典序_贪心_q1053 {

    @Test
    public void test() {
//        System.out.println(Arrays.toString(prevPermOpt1(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(prevPermOpt1(new int[]{3, 1, 1, 3})));
        System.out.println(Arrays.toString(prevPermOpt1(new int[]{3, 2, 1})));
    }

    public int[] prevPermOpt1(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = arr.length - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                return arr;
            }
        }
        return arr;
    }

//    public int[] prevPermOpt1(int[] arr) {
//        int[] res = null;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    int[] te = new int[arr.length];
//                    System.arraycopy(arr, 0, te, 0, arr.length);
//                    int temp = te[i];
//                    te[i] = te[j];
//                    te[j] = temp;
//                    if (res == null || replace(res, te)) {
//                        res = te;
//                    }
//                }
//            }
//        }
//        return res == null ? arr : res;
//    }
//
//    boolean compare(int[] src, int[] desc) {
//        for (int i = 0; i < src.length; i++) {
//            if (src[i] < desc[i]) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    boolean replace(int[] res, int[] te) {
//        //如果遇到的第一个不等的数，大就换
//        for (int i = 0; i < res.length; i++) {
//            if (te[i] < res[i]) {
//                return false;
//            }else if (te[i] > res[i]){
//                return true;
//            }
//        }
//        return true;
//    }

}
