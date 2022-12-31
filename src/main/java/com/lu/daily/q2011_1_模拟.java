package com.lu.daily;

/**
 * @author sheldon
 * @date 2022-12-31
 */
public class q2011_1_模拟 {

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
