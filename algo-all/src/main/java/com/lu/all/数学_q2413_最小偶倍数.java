package com.lu.all;

/**
 * @author sheldon
 * @date 2023-04-21
 */
public class 数学_q2413_最小偶倍数 {

    public int smallestEvenMultiple(int n) {
        if(n==1){
            return 2;
        }
        if(n%2==0){
            return n;
        }else{
            return 2*n;
        }
    }

}
