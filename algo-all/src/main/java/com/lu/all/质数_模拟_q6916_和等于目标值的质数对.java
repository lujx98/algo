package com.lu.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-07-02
 */
public class 质数_模拟_q6916_和等于目标值的质数对 {

    @Test
    public void test() {
        System.out.println(findPrimePairs(10));
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                res.add(Arrays.asList(i, n - i));
            }
        }
        return res;
    }

    public static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        //判断一个数能否被小于sqrt(n)的数整除
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
