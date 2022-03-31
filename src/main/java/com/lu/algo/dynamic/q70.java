package com.lu.algo.dynamic;

/**
 * @author sheldon
 * @date 2022-03-19
 */
public class q70 {

    public static void main(String[] args) {
        climbStairs(3);
    }

    public static int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int[] ints = new int[n];
        ints[0]=1;
        ints[1]=2;
        for (int i = 2; i < n; i++) {
            ints[i]=ints[i-1]+ints[i-2];
        }
        return ints[n-1];
    }

}

