package com.lu.algo.binary.easy;

/**
 * @author sheldon
 * @date 2022-03-16
 */
public class q367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
    }

    public static boolean isPerfectSquare(int num) {
        int right = num;
        int left = 0;
        while (right >= left){
            int mid = left -(left -  right)/2;
            if ((long)mid*mid<num){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return left*left ==num;
    }
}
