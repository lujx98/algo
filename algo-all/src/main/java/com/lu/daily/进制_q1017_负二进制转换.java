package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-04-06
 */
public class 进制_q1017_负二进制转换 {

    //十进制转二进制 都可以用短除法转换
    //如果是负进制，并且得出来的余数为负数的话：
    //求绝对值   所得的差值用商去补
    //比如负二进制得出余数为-1，则转为1。其中有2的差值哪里来呢。从商中补  n1 = n2 * -2 * 商 + 余数
    //余数加了2，为了保持等式相等，要将等式右边 + 2，也即商加1

    // 如果十进制转 M 进制，若 M > 0，则需要下取整；若 M < 0，则需要上取整。

    @Test
    public void test() {
        System.out.println(baseNeg2(4));
        System.out.println(baseNeg2(3));
        System.out.println(baseNeg2(2));
    }

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int i = n % -2;
            n = n / -2;
            if (i < 0) {
                n++;
                i = i * -1;
            }
            sb.append(i);
        }
        return sb.reverse().toString();
    }

}
