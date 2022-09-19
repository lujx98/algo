package com.lu.dmsxl;

import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-09-19
 */
public class String_q14_0_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; true ; j++) {
            boolean back = false;
            char a ='a';
            for (int i = 0; i < strs.length; i++) {
                if (i == 0) {
                    a = strs[i].charAt(j);
                    continue;
                }
                if (Objects.equals(strs[i].charAt(j), a)) {
                    continue;
                }else {
                    back = true;
                }
            }
            if (back){
                break;
            }else {
                stringBuilder.append(a);
            }
        }
        return stringBuilder.toString();
    }

}
