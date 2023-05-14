package com.lu.all;

/**
 * @author sheldon
 * @date 2023-05-14
 */
public class 模拟_q6366_老人的数目 {

    public int countSeniors(String[] details) {
        int res = 0;
        for (String detail : details) {
            String substring = detail.substring(detail.length() - 4, detail.length() - 2);
            if (Integer.parseInt(substring) > 60) {
                res++;
            }
        }
        return res;
    }

}
