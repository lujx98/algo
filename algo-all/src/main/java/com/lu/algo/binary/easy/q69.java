package com.lu.algo.binary.easy;

/**
 * @author sheldon
 * @date 2022-03-15
 */
public class q69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    public static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int right = x;
        int left = 0;
        int ans = right/2;
        while (left<=right) {
            int mid = (right + left) >> 1;
            //Long !!!!
            if ((long)mid * mid <= x) {
                left = mid +1;
                ans = mid;
            } else {
                right = mid -1;
            }
        }
        return ans;
    }
}
