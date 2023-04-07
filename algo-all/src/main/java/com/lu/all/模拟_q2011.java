package com.lu.all;

/**
 * @author sheldon
 * @date 2022-12-31
 */
public class 模拟_q2011 {

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.startsWith("+")||operation.endsWith("+")){
                res++;
            } else if (operation.startsWith("-") || operation.endsWith("-")) {
                res--;
            }
        }
        return res;
    }

}
