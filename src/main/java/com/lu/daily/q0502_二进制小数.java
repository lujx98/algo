package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-03-02
 */
public class q0502_二进制小数 {

    @Test
    public void test(){
        System.out.println(printBin(0.1D));
    }

    public String printBin(double num) {
        StringBuilder builder = new StringBuilder();
        builder.append("0.");
        while (builder.length() < 32) {
            double v = num * 2;
            if (v > 1) {
                builder.append(1);
                v -= 1;
            } else if (v < 1) {
                builder.append(0);
            } else {
                builder.append(1);
                return builder.toString();
            }
            num = v;
        }
        return "ERROR";
    }

}
